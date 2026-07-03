import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import {
  FormBuilder,
  FormGroup,
  ReactiveFormsModule,
  Validators
} from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';

import { OrderService } from '../../services/order.service';
import { OrderRequest } from '../../models/order-request';

@Component({
  selector: 'app-order-create',
  standalone: true,
  imports: [
    CommonModule,
    ReactiveFormsModule
  ],
  templateUrl: './order-create.component.html',
  styleUrl: './order-create.component.css'
})
export class OrderCreateComponent {

  studentId!: number;

  form: FormGroup;

  statuses = [
    'PENDING',
    'PAID'
  ];

  constructor(
    private fb: FormBuilder,
    private route: ActivatedRoute,
    private router: Router,
    private orderService: OrderService
  ) {

    this.studentId = Number(this.route.snapshot.paramMap.get('id'));

    this.form = this.fb.group({

      description: [
        '',
        Validators.required
      ],

      total: [
        null,
        [
          Validators.required,
          Validators.min(0.01),
          Validators.pattern(/^\d+(\.\d{1,2})?$/)
        ]
      ],

      status: [
        'PENDING',
        Validators.required
      ]

    });

  }

  onSubmit(): void {

    if (this.form.invalid) {
      this.form.markAllAsTouched();
      return;
    }

    const request: OrderRequest = this.form.value as OrderRequest;

    this.orderService.createOrder(this.studentId, request)
      .subscribe({

        next: () => {
          this.router.navigate([`/students/${this.studentId}/orders`]);
        },

        error: err => {
          console.error(err);
        }

      });

  }

  goBack(): void {
    this.router.navigate([`/students/${this.studentId}/orders`]);
  }

  get description() {
    return this.form.get('description');
  }

  get total() {
    return this.form.get('total');
  }

  get status() {
    return this.form.get('status');
  }

}

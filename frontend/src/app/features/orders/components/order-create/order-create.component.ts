import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { OrderService } from '../../services/order.service';
import { OrderRequest } from '../../models/order-request';

@Component({
  selector: 'app-order-create',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './order-create.component.html',
  styleUrl: './order-create.component.css'
})
export class OrderCreateComponent implements OnInit {

  studentId!: number;

  order: OrderRequest = {
    description: '',
    total: 0,
    status: 'PENDING'
  };

  statuses = ['PENDING', 'PAID'];

  constructor(
    private route: ActivatedRoute,
    private orderService: OrderService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.studentId = Number(this.route.snapshot.paramMap.get('id'));
  }

  onSubmit(): void {
    this.orderService.createOrder(this.studentId, this.order).subscribe({
      next: () => {
        this.router.navigate([`/students/${this.studentId}/orders`]);
      },
      error: err => console.error(err)
    });
  }

  goBack(): void {
    this.router.navigate([`/students/${this.studentId}/orders`]);
  }
}

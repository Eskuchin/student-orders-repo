import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { CommonModule } from '@angular/common';

import { OrderService } from '../../services/order.service';
import { OrderResponse } from '../../models/order-response';

import { signal } from '@angular/core';

@Component({
  selector: 'app-order-list',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './order-list.component.html',
  styleUrl: './order-list.component.css'
})
export class OrderListComponent implements OnInit {

  studentId!: number;
  orders = signal<OrderResponse[]>([]);

  constructor(
    private route: ActivatedRoute,
    private orderService: OrderService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.route.paramMap.subscribe(params => {
      this.studentId = Number(params.get('id'));
      this.loadOrders();
    });
  }

  loadOrders(): void {
    this.orderService.getOrders(this.studentId).subscribe({
      next: data => this.orders.set(data),
      error: err => console.error(err)
    });
  }

  goToCreate(): void {
    this.router.navigate([`/students/${this.studentId}/orders/new`]);
  }

  goBack(): void {
    this.router.navigate(['/students']);
  }
}

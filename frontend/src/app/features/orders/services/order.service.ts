import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { OrderRequest } from '../models/order-request';
import { OrderResponse } from '../models/order-response';

@Injectable({
  providedIn: 'root'
})
export class OrderService {

  constructor(private http: HttpClient) {}

  getOrders(studentId: number): Observable<OrderResponse[]> {
    return this.http.get<OrderResponse[]>(
      `http://localhost:8080/students/${studentId}/orders`
    );
  }

  createOrder(studentId: number, request: OrderRequest): Observable<OrderResponse> {
    return this.http.post<OrderResponse>(
      `http://localhost:8080/students/${studentId}/orders`,
      request
    );
  }
}

import { Routes } from '@angular/router';
import { StudentListComponent } from './features/students/components/student-list/student-list.component';
import { StudentCreateComponent } from './features/students/components/student-create/student-create.component';
import { OrderListComponent } from './features/orders/components/order-list/order-list.component';
import { OrderCreateComponent } from './features/orders/components/order-create/order-create.component';


export const routes: Routes = [
  {
    path: '',
    redirectTo: 'students',
    pathMatch: 'full'
  },
  {
    path: 'students',
    component: StudentListComponent
  },
  {
    path: 'students/new',
    component: StudentCreateComponent
  },
  {
    path: 'students/:id/orders',
    component: OrderListComponent
  },
  {
    path: 'students/:id/orders/new',
    component: OrderCreateComponent
  }
];

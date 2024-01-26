import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CustomerListComponent } from './customer-list/customer-list.component';
import { CreateCustomerComponent } from './create-customer/create-customer.component';
import { UpdateCustomerComponent } from './update-customer/update-customer.component';
import { HomeComponent } from './home/home.component';
import { RestaurantListComponent } from './restaurant-list/restaurant-list.component';
import { CreateRestaurantComponent } from './create-restaurant/create-restaurant.component';
import { UpdateRestaurantComponent } from './update-restaurant/update-restaurant.component';
import { OrderListComponent } from './order-list/order-list.component';
import { CreateOrderComponent } from './create-order/create-order.component';
import { UpdateOrderComponent } from './update-order/update-order.component';
import { BillListComponent } from './bill-list/bill-list.component';
import { CreateBillComponent } from './create-bill/create-bill.component';
import { UpdateBillComponent } from './update-bill/update-bill.component';
import { ItemListComponent } from './item-list/item-list.component';
import { CreateItemComponent } from './create-item/create-item.component';
import { UpdateItemComponent } from './update-item/update-item.component';
import { LoginComponent } from './login/login.component';
import { HomepageComponent } from './homepage/homepage.component';
import { NavbarComponent } from './navbar/navbar.component';
import { UserpanelComponent } from './userpanel/userpanel.component';
import { AdminpanelComponent } from './adminpanel/adminpanel.component';
import { SignupComponent } from './signup/signup.component';



const routes: Routes = [
  {path:'customers',component:CustomerListComponent},
  {path:'customers/addnewcustomer',component:CreateCustomerComponent},
  {path:'customers/:customerId',component:UpdateCustomerComponent},
  {path:'home',component:HomeComponent},
  {path:'restaurants',component:RestaurantListComponent},
  {path:'restaurants/addnewrestaurant',component:CreateRestaurantComponent},
  {path:'restaurants/:restaurantId',component:UpdateRestaurantComponent},
  {path:'orders',component:OrderListComponent},
  {path:'orders/addneworder',component:CreateOrderComponent},
  {path:'orders/:orderId',component:UpdateOrderComponent},
  {path:'bills',component:BillListComponent},
  {path:'bills/addnewbill',component:CreateBillComponent},
  {path:'bills/:billId',component:UpdateBillComponent},
  {path:'items',component:ItemListComponent},
  {path:'items/addnewitem',component:CreateItemComponent},
  {path:'items/:itemId',component:UpdateItemComponent},
  {path:'login',component:LoginComponent},
  {path:'',component:HomepageComponent},
  {path:'navbar',component:NavbarComponent},
  {path:'userpanel',component:UserpanelComponent},
  {path:'adminpanel',component:AdminpanelComponent},
  {path:'signup',component:SignupComponent},
];
  
  
  
  


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

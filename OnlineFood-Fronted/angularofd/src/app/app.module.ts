import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';
import { HttpClientModule } from '@angular/common/http';
import { CustomerListComponent } from './customer-list/customer-list.component';
import { CreateCustomerComponent } from './create-customer/create-customer.component';
import { UpdateCustomerComponent } from './update-customer/update-customer.component';
import { HomeComponent } from './home/home.component';
import { CreateRestaurantComponent } from './create-restaurant/create-restaurant.component';
import { RestaurantListComponent } from './restaurant-list/restaurant-list.component';
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
import { AdminpanelComponent } from './adminpanel/adminpanel.component';
import { UserpanelComponent } from './userpanel/userpanel.component';
import { SignupComponent } from './signup/signup.component';

@NgModule({
  declarations: [
    AppComponent,
    CustomerListComponent,
    CreateCustomerComponent,
    UpdateCustomerComponent,
    HomeComponent,
    CreateRestaurantComponent,
    RestaurantListComponent,
    UpdateRestaurantComponent,
    OrderListComponent,
    CreateOrderComponent,
    UpdateOrderComponent,
    BillListComponent,
    CreateBillComponent,
    UpdateBillComponent,
    ItemListComponent,
    CreateItemComponent,
    UpdateItemComponent,
    LoginComponent,
    HomepageComponent,
    NavbarComponent,
    AdminpanelComponent,
    UserpanelComponent,
    SignupComponent,
    
    
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    RouterModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

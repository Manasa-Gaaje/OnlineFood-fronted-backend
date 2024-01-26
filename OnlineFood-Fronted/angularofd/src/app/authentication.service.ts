import { Injectable } from '@angular/core';
import { Customer } from './customer';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService 
{
  customers : Customer[]=[];

  constructor(private httpClient: HttpClient) { }

  //Retrieves user token and checks authentication
  authenticate() {
    return true
    // return this.httpClient.post<any>('http://localhost:8080/authenticate', { username, password }).pipe(tap(userData => {
    //   sessionStorage.setItem('username', username);
    //   let tokenStr = 'Bearer' + userData.token;
    //   sessionStorage.setItem('token', tokenStr);
    //   })
    // );
  }

  // Checks whether the user is logged in
  isUserLoggedIn():boolean {
    let customer = sessionStorage.getItem('fullName')
    return !(customer === null)
  }

  // Removes user session(logout)
  logOut() {
    sessionStorage.removeItem('fullName');
  }

  // //log in
  // longIn(userId: number){
  //   return this.httpClient.get('http://localhost:8080/login/' + userId);
  // }

  // Retrives role of user(customer/admin)
  getRole(fullName:String) {
    return this.httpClient.get('http://localhost:8080/getRole?username='+ fullName);
  }

  // Adds a new User
  signUp(customer: Customer): Observable<any> {
    return this.httpClient.post<Customer>('http://localhost:8082/signup', customer);
    }
  }
  //.pipe(switchMap(() => this.authenticate(user.userName, user.userPassword)))ś



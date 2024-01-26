import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AuthenticationService } from '../authentication.service';
import { Customer } from '../customer';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent 
{
  customer: Customer = new Customer();
  fullNameFlag: boolean = false;
  mobileNumberFlag: boolean = false;
  emailFlag: boolean = false;
  buttonFlag: boolean = true;

  constructor(
    private authService: AuthenticationService,
    private router: Router
  ) {}

  validateName(): void {
    this.fullNameFlag = this.customer.fullName.length < 3;
  }

  validatePhone(): void {
    this.mobileNumberFlag = !/^\d{10}$/.test(this.customer.mobileNumber.toString());
  }

  validateEmail(): void {
    this.emailFlag = !/^[^\s@]+@[^\s@]+\.[^\s@]+$/.test(this.customer.email.toString());
  }

  enableButton(): void {
    this.buttonFlag = this.fullNameFlag || this.mobileNumberFlag || this.emailFlag;
  }

  signUp(): void {
    if (!this.buttonFlag) {
      this.authService.signUp(this.customer).subscribe(
        () => {
          this.router.navigate(['/login']);
        },
        (error: any) => {
          console.error('Registration error:', error);
        }
      );
    }
  }


}

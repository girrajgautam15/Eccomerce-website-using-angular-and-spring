import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { User } from '../User';
import { FormControlName, FormGroup, FormsModule, ReactiveFormsModule, Validators,FormControl, FormBuilder } from '@angular/forms';
import { ServiceService } from '../service.service';
import { error } from 'console';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [CommonModule,FormsModule,ReactiveFormsModule],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent implements OnInit {

constructor(private service:ServiceService,private route:Router,private formBuilder:FormBuilder){}


  user:User=new User();
  login=true;
//   id!:number;
  
  ngOnInit():void{

  }
  toggleLogin() {
    this.login=!this.login;
  }

  us!:User;
  OnLogin() {
    this.service.getUser(this.user.username).subscribe(data => {
      this.us = data;
      // console.log(this.us); // This will log the data after it's received
  
      if (this.us.password === this.user.password) {
        this.service.setPerson(this.us);
        console.log(this.service.getPerson());
        this.route.navigate(['/items']);
      } else {
        alert("User Not Found");
      }
    });
  }
onRegister() {
  this.service.addUser(this.user).subscribe(data=>{
    console.log("Saved");
  })
  }
  
  // userForm:FormGroup=new FormGroup({
  //   name:new FormControlName(''),
  //   username:new FormControlName(''),
  //   password:new FormControlName('')
  // });
  // userForm: FormGroup = new FormGroup({
  //   name: new FormControl(''),
  //   username: new FormControl(''),
  //   password: new FormControl('')
  // });
  // userForm:FormGroup=this.formBuilder.group({
  //   name:[''],
  //   username:[''],
  //   password:['']
  // })

  // onSubmit() {
  //   this.user=this.userForm.value;
  //   console.log(this.user);
  //   }
}

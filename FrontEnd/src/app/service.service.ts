import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Item } from './Item';
import { Observable } from 'rxjs';
import { User } from './User';

@Injectable({
  providedIn: 'root'
})
export class ServiceService {

  constructor(private httpClient:HttpClient) { }
  private baseURL="http://localhost:8085/details/";
  user:User=new User();

  getPerson(){
    return (this.user);
  }
  setPerson(use:User){
    this.user=use;
  }
 
  getAll(): Observable<Item[]>{
    return this.httpClient.get<Item[]>(`${this.baseURL}items`);
  }
  getUser(username:string): Observable<User>{
    const url = `${this.baseURL}${username}`; 
    return this.httpClient.get<User>(url);
  }
   addUser(user:User):Observable<User>{
    return this.httpClient.post<User>(`${this.baseURL}save`,user);
   }

   addToCart(item:Item):Observable<Item>{
    console.log(this.user.username);
    return this.httpClient.put<Item>(`${this.baseURL}${this.user.username}/cart/add/${item.id}`,null);
   }
   removeFromCart(item:Item):Observable<Item>{
    console.log(this.user.username);
    return this.httpClient.delete<Item>(`${this.baseURL}${this.user.username}/cart/delete/${item.id}`);
   }

}

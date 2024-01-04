import { Component, OnInit } from '@angular/core';
import { Item } from '../Item';
import { ServiceService } from '../service.service';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-items',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './items.component.html',
  styleUrl: './items.component.css'
})
export class ItemsComponent implements OnInit {

  constructor(private service:ServiceService){}
  items:Item[]=[];
  ngOnInit():void{
    this.service.getAll().subscribe(data=>{
      this.items=data;
      // console.log(data);
    })
  }
  
  addToCart(index:number){
      this.service.addToCart(this.items[index]).subscribe(data=>{
        console.log("added");
      })
    }

    removeFromCart(index:number){
      this.service.removeFromCart(this.items[index]).subscribe(data=>{
        console.log("removed");
      })
    }
}

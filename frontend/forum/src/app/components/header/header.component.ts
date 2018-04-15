import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { menuItem } from './menuItem';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  menuItems: Array<menuItem> = [
    {name: "HomePage", link: ""},
    {name: "Sign in/up", link: "login"},
    {name: "Contact", link: "contact"},
    
  ];
  menu: menuItem = this.menuItems[0];
  navigate(name : string){
    console.log("NAVIGATED");
    this.router.navigate(["./" + name]);
  }

  constructor(private router: Router) { }

  ngOnInit() {
  }

}

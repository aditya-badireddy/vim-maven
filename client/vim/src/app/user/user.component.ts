import { Component, OnInit } from '@angular/core';
import { UsersService } from '../services/users.service';
@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {
  public pageTitle: String;
  public users: {};
  constructor(private _usersService: UsersService) { }
  public getUsers(): void {
    this._usersService.getUsers()
      .subscribe(users => this.users = users);
  }
  public showUsers(): void {
    this.getUsers();
  }
  ngOnInit(): void {
    this.pageTitle = 'Users';
  }

}

import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { Observable } from 'rxjs/Observable';
import { of } from 'rxjs/observable/of';
import { catchError, map, tap } from 'rxjs/operators';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable()
export class UsersService {
  private usersUrl = 'http://localhost:8180/vim-maven/api/users/';
  private deleteUrl = 'http://localhost:8180/vim-maven/api/users/deleteUser/';
  constructor(private http: HttpClient) { }
  public getUsers(): Observable<any> {
    return this.http.get(this.usersUrl, httpOptions)
      .pipe(
      tap(Users => console.log(`fetched Users`)),
      catchError(this.handleError('getUsers', []))
      );
  }

  public deleteUser(userName): Observable<any> {
    return this.http.post(this.deleteUrl+userName+"/", httpOptions)
      .pipe(
      tap(msg => console.log(`Deleted User`)),
      catchError(this.handleError('deleteUser', []))
      );
  }
  /**
  * Handle Http operation that failed.
  * Let the app continue.
  * @param operation - name of the operation that failed
  * @param result - optional value to return as the observable result
  */
  private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {
      console.error(error); // log to console instead
      return of(result as T);
    };
  }
}

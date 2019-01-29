import { Injectable } from '@angular/core';
import { Http, Response, Headers, RequestOptions } from '@angular/http'; 
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import 'rxjs/add/observable/throw';
import { User } from '../user';
import { userInfo } from 'os';

@Injectable({
  providedIn: 'root'
})
export class UserService {  
  private baseUrl:string='http://localhost:8080/api';
  private headers = new Headers({'Content-Type':'application/json','Access-Control-Allow-Origin':'*','Access-Control-Allow-Methods':'GET, PUT, POST, DELETE',
'Access-Control-Allow-Headers':'Cache-Control, Pragma, Origin, Authorization,   Content-Type, X-Requested-With'});
  private options = new RequestOptions({headers:this.headers});
  private user:User;
  constructor(private _http:Http) { }

  getUsers(){

    return this._http.get(this.baseUrl+'/users',this.options).map((response:Response) => response.json());
    
  }

  getUser(id:Number){

    return this._http.get(this.baseUrl+'/user/'+id,this.options).map((response:Response) => response.json())
    .catch(this.errorHandler);
    
  }

  deleteUser(id:Number){

    return this._http.delete(this.baseUrl+'/user/'+id,this.options).map((response:Response) => response.json())
    .catch(this.errorHandler);
    
  }

  createUser(user:User){

    return this._http.post(this.baseUrl+'/user',JSON.stringify(user), this.options).map((response:Response) => response.json())
    .catch(this.errorHandler);
    
  }

  updateUser(user:User){

    return this._http.put(this.baseUrl+'/user',JSON.stringify(user), this.options).map((response:Response) => response.json())
    .catch(this.errorHandler);
    
  }

  errorHandler(error:Response){

    return Observable.throw(error||'SERVER ERROR');

  }

  setter(user:User) {
    this.user = user;
  }
  
  getter() {
    return this.user;
  }
}
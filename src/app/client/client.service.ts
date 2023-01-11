import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { client } from '../interfaceClient';

@Injectable({
  providedIn: 'root'
})
export class ClientService {
 
  constructor( private httpClient:HttpClient) { }

  
  getClients() {
       return this.httpClient.get<client[]>('http://localhost:12037/medecin/list');
  }

  // public deleteEmployee(employee: client) {
  //   return this.httpClient.delete<client>("http://localhost:8080/employees" + "/"+ employee.id);
  // }

  public createEmployee(employee: client) {
    return this.httpClient.post<client>("http://localhost:12037/medecin/save", employee);
  }
}

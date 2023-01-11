import { Component, OnInit } from '@angular/core';
import { client } from '../interfaceClient';
import { ClientService } from './client.service';

@Component({
  selector: 'app-client',
  templateUrl: './client.component.html',
  styleUrls: ['./client.component.css']
})
export class ClientComponent implements OnInit {

  client!: client[];
  
  constructor(private ClientService:ClientService) { }

  ngOnInit(): void {
    this.ClientService.getClients().subscribe(
      response =>this.handleSuccessfulResponse(response),
     );
  }

  handleSuccessfulResponse(response:client[]) {
    this.client=response;
  }

// deleteEmployee(employee: Employee): void {
//    this.httpClientService.deleteEmployee(employee)
//      .subscribe( data => {
//       this.employees = this.employees.filter(u => u !== employee);
//    })
// };

}

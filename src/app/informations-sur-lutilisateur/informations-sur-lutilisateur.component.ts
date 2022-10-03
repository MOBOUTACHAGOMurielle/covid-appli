import { Component, Input, OnInit } from '@angular/core';
import { client } from '../interfaceClient';

@Component({
  selector: 'app-informations-sur-lutilisateur',
  templateUrl: './informations-sur-lutilisateur.component.html',
  styleUrls: ['./informations-sur-lutilisateur.component.css']
})
export class InformationsSurLutilisateurComponent implements OnInit {
  nom: string= "";
  prenom: string= "";
  email: string= "";
  Date: Date = new Date();
  @Input() centerClient: client = {
    id: 7,
    name: "Dupont",
    prenom: "junior",
    email: "dupontJunior@gmail.com",
    Date: new Date()
  };

  onChosed(aclient: client){
     /* this.centerClient.splice(this.centerClient) */
  }

  constructor() { }

  ngOnInit(): void {
  }

}

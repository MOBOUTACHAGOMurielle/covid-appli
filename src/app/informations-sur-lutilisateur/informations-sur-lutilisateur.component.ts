import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { client } from '../interfaceClient';
import { covid } from '../interfaceCovid';

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

  centerClient?: client;/*  = {
    id: 7,
    name: "Dupont",
    prenom: "junior",
    email: "dupontJunior@gmail.com",
    Date: new Date()
  }; */

  @Input() center?: covid;

  @Input() patient?: client;

  @Output() reserve = new EventEmitter<client>();

  onChosed(aclient: client){
     /* this.centerClient.splice(this.centerClient) */
  }

  constructor() { }

  ngOnInit(): void {
  }

  Reserver(): void {
    this.reserve.emit(this.patient);
  }

}

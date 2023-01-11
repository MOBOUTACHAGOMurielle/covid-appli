import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { client } from '../interfaceClient';
import { covid } from '../interfaceCovid';
import { centreService } from '../affichage-des-centres/affichage-des-centres.service';
import { DialogRef } from '@angular/cdk/dialog';

@Component({
  selector: 'app-informations-sur-lutilisateur',
  templateUrl: './informations-sur-lutilisateur.component.html',
  styleUrls: ['./informations-sur-lutilisateur.component.css']
})
export class InformationsSurLutilisateurComponent implements OnInit {
  // nom: string= "";
  // prenom: string= "";
  // email: string= "";
  // Date: Date = new Date();

  // centerClient?: client;/*  = {
  //   id: 7,
  //   name: "Dupont",
  //   prenom: "junior",
  //   email: "dupontJunior@gmail.com",
  //   Date: new Date()
  // }; */

  // @Input() center?: covid;

  // onChosed(aclient: client){
  //    /* this.centerClient.splice(this.centerClient) */
  // }

  // constructor() { }

  // ngOnInit(): void {
  // }

  // Reserver(): void {
    
  // }

  constructor(public centreService:centreService,
    public dialogRef: DialogRef<InformationsSurLutilisateurComponent>) { }

    ngOnInit(): void {
    }

    onClear() {
      this.centreService.form.reset();
      this.centreService.initializeFormGroup();
    }

    onClose() {
      this.centreService.form.reset();
      this.centreService.initializeFormGroup();
      this.dialogRef.close();
    }
}

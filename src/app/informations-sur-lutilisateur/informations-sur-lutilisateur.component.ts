import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { client } from '../interfaceClient';
import { covid } from '../interfaceCovid';
import { DialogRef } from '@angular/cdk/dialog';
import { infoService } from './informations-sur-lutilisateur.service';

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

  constructor(public infoService:infoService,
    public dialogRef: DialogRef<InformationsSurLutilisateurComponent>) { }

    ngOnInit(): void {
    }

    onClear() {
      this.infoService.UserForm.reset();
      this.infoService.initializeUserFormGroup();
    }

    onSubmit() {
        this.infoService.addNewMedecin(this.infoService.UserForm.value); 
    }

    onClose() {
      this.infoService.UserForm.reset();
      this.infoService.initializeUserFormGroup();
      this.dialogRef.close();
    }
}

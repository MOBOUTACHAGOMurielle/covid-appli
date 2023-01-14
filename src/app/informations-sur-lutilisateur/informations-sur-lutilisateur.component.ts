import { Component, EventEmitter, Inject, Input, OnInit, Output } from '@angular/core';
import { client } from '../interfaceClient';
import { covid } from '../interfaceCovid';
import { DialogRef } from '@angular/cdk/dialog';
import { infoService } from './informations-sur-lutilisateur.service';
import { centreService } from '../affichage-des-centres/affichage-des-centres.service';
import { personnelService } from '../personnel-dun-centre/personnel-dun-centre.service';
import { MAT_DIALOG_DATA } from '@angular/material/dialog';

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
    public personneCentre:personnelService,
    public dialogRef: DialogRef<InformationsSurLutilisateurComponent>,
    @Inject(MAT_DIALOG_DATA) public data: {center: covid}) {

      this.centre=data.center;

    }
   
    centre: covid;

    ngOnInit(): void {
    }

    onClear() {
      this.infoService.UserForm.reset();
      this.infoService.initializeUserFormGroup();
    }

    onSubmitMedecin() {
        this.infoService.adMedecinToCentre(this.infoService.UserForm.value,this.centre.id); 
        this.onClose();
    }

    onClose() {
      this.infoService.UserForm.reset();
      this.infoService.initializeUserFormGroup();
      this.dialogRef.close();
    }
}

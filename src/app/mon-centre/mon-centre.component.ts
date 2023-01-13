import { Component, OnInit } from '@angular/core';
import { MatDialog, MatDialogConfig } from '@angular/material/dialog';
import { InformationsSurLutilisateurComponent } from '../informations-sur-lutilisateur/informations-sur-lutilisateur.component';
import { PersonnelDunCentreComponent } from '../personnel-dun-centre/personnel-dun-centre.component';
import { personnelService } from '../personnel-dun-centre/personnel-dun-centre.service';

@Component({
  selector: 'app-mon-centre',
  templateUrl: './mon-centre.component.html',
  styleUrls: ['./mon-centre.component.css']
})
export class MonCentreComponent implements OnInit {

    constructor(public personnelService:personnelService,private dialog: MatDialog) { }

  medecins!: PersonnelDunCentreComponent;

  ngOnInit(): void {
  }
}

import { DialogRef } from '@angular/cdk/dialog';
import { Component, OnInit } from '@angular/core';
import { MatDialog, MatDialogConfig } from '@angular/material/dialog';
import { MatTableDataSource } from '@angular/material/table';
import { InformationsSurLutilisateurComponent } from '../informations-sur-lutilisateur/informations-sur-lutilisateur.component';
import { infoService } from '../informations-sur-lutilisateur/informations-sur-lutilisateur.service';
import { client } from '../interfaceClient';
import { covid } from '../interfaceCovid';
import { personnelService } from './personnel-dun-centre.service';

@Component({
  selector: 'app-personnel-dun-centre',
  templateUrl: './personnel-dun-centre.component.html',
  styleUrls: ['./personnel-dun-centre.component.css']
})
export class PersonnelDunCentreComponent implements OnInit {
  [x: string]: any;

  constructor(public personnelService:personnelService,
    public infoService: infoService,
    private dialog: MatDialog,
    public dialogRef: DialogRef<PersonnelDunCentreComponent>) { }

    listData!: MatTableDataSource<any>;
    displayedColumns: string[] = ['id', 'nom', 'actions'];
    listeAdmins: client[] = [];
    listeMedecins: client[] = [];
    centre!: covid;

  ngOnInit(): void {
    this.personnelService.getAdminByCentre(this.centre.id).subscribe(
      (listeAdmins : client []) => {
        this.listeAdmins = listeAdmins;
      },

    );

    this.personnelService.getMedecinsByCentre(this.centre.id).subscribe(
    (listeMedecins : client []) => {
        this.listeMedecins = listeMedecins;
      },
    );
  }

  onDelete(id:any){

  }

  onEdit(row:any){
    
  }

 
  onClose() {
    this.personnelService.formPersonnel.reset();
    this.personnelService.initializePersonnelFormGroup();
    this.dialogRef.close();
  }

  onViewPersonnel() {
    this.infoService.initializeUserFormGroup;
    const dialogConfig = new MatDialogConfig();
    dialogConfig.disableClose = true;
    dialogConfig.autoFocus = true;
    dialogConfig.width = "40%";
    dialogConfig.panelClass = 'bg-color'
    this.dialog.open(InformationsSurLutilisateurComponent,dialogConfig);
  }


}

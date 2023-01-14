import { DialogRef } from '@angular/cdk/dialog';
import { Component, Inject, Input, OnInit } from '@angular/core';
import { MatDialog, MatDialogConfig, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { MatTableDataSource } from '@angular/material/table';
import { InformationsSurAdminComponent } from '../informations-sur-admin/informations-sur-admin.component';
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

  constructor(public personnelService:personnelService,
    public infoService: infoService,
    private dialog: MatDialog,
    public dialogRef: DialogRef<PersonnelDunCentreComponent>,
    @Inject(MAT_DIALOG_DATA) public data: {center: covid}) {

      this.centre=data.center;

    }

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

  setcentre(acentre:covid):void {
    this.centre = acentre;
  }

  onClose() {
    this.personnelService.formPersonnel.reset();
    this.personnelService.initializePersonnelFormGroup();
    this.dialogRef.close();
  }

  onViewAdmin() {
    this.infoService.initializeUserFormGroup;
    this.dialog.open(InformationsSurAdminComponent,{data: {center:this.centre} ,width:'40%',disableClose:true,autoFocus:true,panelClass:'bg-color'});
  }

  onViewMedecin() {
    this.infoService.initializeUserFormGroup;
    this.dialog.open(InformationsSurLutilisateurComponent,{data: {center:this.centre} ,width:'40%',disableClose:true,autoFocus:true,panelClass:'bg-color'});
  }

}

import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { personnelService } from '../personnel-dun-centre/personnel-dun-centre.service';
import { infoService } from '../informations-sur-lutilisateur/informations-sur-lutilisateur.service';
import { MatTableDataSource } from '@angular/material/table';
import { client } from '../interfaceClient';
import { covid } from '../interfaceCovid';
import { InformationsSurLutilisateurComponent } from '../informations-sur-lutilisateur/informations-sur-lutilisateur.component';

@Component({
  selector: 'app-config',
  templateUrl: './config.component.html',
  styleUrls: ['./config.component.css']
})
export class ConfigComponent implements OnInit {

  constructor(public personnelService:personnelService,
    public infoService: infoService,
    private dialog: MatDialog) { }

    listData!: MatTableDataSource<any>;
    displayedColumns: string[] = ['id', 'nom', 'actions'];
    listeSuperAdmins: client[] = [];
    centre!: covid;

  ngOnInit(): void {
    this.personnelService.getSuperAdmins().subscribe(
      (listeSuperAdmins : client []) => {
          this.listeSuperAdmins = listeSuperAdmins;
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

  // onClose() {
  //   this.personnelService.formPersonnel.reset();
  //   this.personnelService.initializePersonnelFormGroup();
  // }

  onViewPersonnel() {
    this.infoService.initializeUserFormGroup;
    this.dialog.open(InformationsSurLutilisateurComponent,{data: {center:this.centre} ,width:'40%',disableClose:true,autoFocus:true,panelClass:'bg-color'});
  }

}

import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { personnelService } from '../personnel-dun-centre/personnel-dun-centre.service';
import { infoService } from '../informations-sur-lutilisateur/informations-sur-lutilisateur.service';
import { MatTableDataSource } from '@angular/material/table';
import { client } from '../interfaceClient';
import { covid } from '../interfaceCovid';
import { InformationsSurSuperAdminComponent } from '../informations-sur-super-admin/informations-sur-super-admin.component';

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
    this.personnelService.deleteSuperAdmin(id); 
  }

  onEdit(row:any){
    
  }

  setcentre(acentre:covid):void {
    this.centre = acentre;
  }

  onViewSuperAdmin() {
    this.infoService.initializeUserFormGroup;
    this.dialog.open(InformationsSurSuperAdminComponent,{data: {center:this.centre} ,width:'40%',disableClose:true,autoFocus:true,panelClass:'bg-color'});
  }

}

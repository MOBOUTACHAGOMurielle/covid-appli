import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { MatTableDataSource } from '@angular/material/table';
import { centreService } from '../affichage-des-centres/affichage-des-centres.service';
import { covid } from '../interfaceCovid';
import { reservation } from '../interfaceReservations';
import { personnelService } from '../personnel-dun-centre/personnel-dun-centre.service';
import { infoService } from '../informations-sur-lutilisateur/informations-sur-lutilisateur.service';
import { InformationsSurLutilisateurComponent } from '../informations-sur-lutilisateur/informations-sur-lutilisateur.component';

@Component({
  selector: 'app-planning',
  templateUrl: './planning.component.html',
  styleUrls: ['./planning.component.css']
})
export class PlanningComponent implements OnInit {

  constructor(public personnelService:personnelService, public centreService: centreService,public infoService: infoService,
    private dialog: MatDialog) { }

  listeReservations: reservation[] = [];
  searchKey:string= " ";
  listData!: MatTableDataSource<any>;
  displayedColumns: string[] = ['id', 'nom', 'actions'];
  centre!: covid;

  ngOnInit(): void {
    this.personnelService.getReservations().subscribe(
      (listeReservations : reservation []) => {
        this.listeReservations = listeReservations;
      },

      //error: err => this.errMsg = err
    );

    this.centreService.search.subscribe((val:any)=>{
      this.searchKey = val;
    })
  }

  applyFilter(event:any){
    this.searchKey = (event.target as HTMLInputElement).value;
    this.centreService.search.next(this.searchKey);
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

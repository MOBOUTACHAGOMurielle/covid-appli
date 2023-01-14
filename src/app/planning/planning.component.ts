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

  constructor(public personnelService:personnelService, public centreService: centreService,
    private dialog: MatDialog) { }

  searchKey:string= " ";
  listData!: MatTableDataSource<any>;
  listeReservations: reservation[] = [];
  displayedColumns: string[] = ['id', 'nom', 'actions'];
  centre!: covid;

  ngOnInit(): void {
    this.personnelService.getAdminCentre(3).subscribe(
     
      (center : covid) => {
        this.listeReservations = center.reservations;
        console.log(center);
      },

      //error: err => this.errMsg = err
    );

    // this.centreService.search.subscribe((val:any)=>{
    //   this.searchKey = val;
    // })
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
    this.personnelService.initializeUserFormGroup;
    this.dialog.open(InformationsSurLutilisateurComponent,{data: {center:this.centre} ,width:'40%',disableClose:true,autoFocus:true,panelClass:'bg-color'});
  }


}

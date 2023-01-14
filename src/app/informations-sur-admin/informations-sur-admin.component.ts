import { DialogRef } from '@angular/cdk/dialog';
import { Component, Inject, OnInit } from '@angular/core';
import { MAT_DIALOG_DATA } from '@angular/material/dialog';
import { covid } from '../interfaceCovid';
import { personnelService } from '../personnel-dun-centre/personnel-dun-centre.service';
import { infoServiceAdmin } from './information-sur-admin.service';

@Component({
  selector: 'app-informations-sur-admin',
  templateUrl: './informations-sur-admin.component.html',
  styleUrls: ['./informations-sur-admin.component.css']
})
export class InformationsSurAdminComponent implements OnInit {

  constructor(public infoService:infoServiceAdmin,
    public personneCentre:personnelService,
    public dialogRef: DialogRef<InformationsSurAdminComponent>,
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

    onSubmitAdmin() {
      this.infoService.adAdminToCentre(this.infoService.UserForm.value,this.centre.id); 
      this.onClose();
  }

    onClose() {
      this.infoService.UserForm.reset();
      this.infoService.initializeUserFormGroup();
      this.dialogRef.close();
    }

}

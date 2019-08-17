import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {

  vehicleForm: FormGroup;
  parkings: any;
  errorAlert: boolean = false;
error_message:string;
  constructor(private http: HttpClient) {

  }

  // your code goes here
  ngOnInit() {
    this.vehicleForm = new FormGroup({
      'vehicleLot': new FormControl('', [Validators.required]);
      'vehicleNumber': new FormControl('', [Validators.required]);
      'vehicleDuration': new FormControl('', [Validators.required]);
      'vehicleAmount': new FormControl('', [Validators.required]);
    });

    this.getAllParkingVehicle();
  }

  getAllParkingVehicle() {
    let url = "http://localhost:8080/api/parkings";
    this.http.get(url).subscribe(
      next: res => {
        this.parkings = res;
      },
      error:err => {
        this.errorAlert = true;
      }
    );
  }

  calculateAmount(event) {

    let DurationinMinutes=event.getValue();
    let hours = Math.floor(DurationinMinutes / 60); 
    let parkingAmount=hours*20;
    this.vehicleForm.get('vehicleAmount').setValue(parkingAmount);

  }
  chkVehicleAlreadyExists(vehicleNum){
     let parkingLot = this.parkings.filter((item) => item.vehicleNumber ==vehicleNum)[0];
     if(parkingLot!=null){
        return true;
     }
     else
     return false;
  }
  onSubmit() {
 let parkingLot ={
          lot:this.vehicleForm.get('vehicleLot').getValue(),
          vehicle_number:this.vehicleForm.get('vehicleNumber').getValue(),
          parking_duration:this.vehicleForm.get('vehicleDuration').getValue(),
           parking_amount:this.vehicleForm.get('vehicleAmount').getValue()
        }
        let vehicleNum=this.vehicleForm.get('vehicleNumber').getValue();
        if(this.chkVehicleAlreadyExists(vehicleNum)){
          this.errorAlert=true;
          this.error_message="Vehicle Already parked;";
        }
    else if (this.vehicleForm.valid) {
       

 
        let url = "http://localhost:8080/api/parkings";
        this.http.post(url,parkingLot).subscribe(
          data=>{
            this.parkings.add(data);
          },
          
      error:err => {
        this.errorAlert = true;
      }
        )
    }

  }
}

import { Component, OnInit, Input, Output } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Purchase } from './purchase';
import { PURCHASES } from './purchase-mockup-data';

@Component({
  selector: 'app-purchases',
  templateUrl: './purchases.component.html',
  styleUrls: ['./purchases.component.css']
})
export class PurchasesComponent implements OnInit {

  purchases: Purchase[];

  @Input()
  purchase: Purchase;

  @Output()
  purchaseSum: number;

  constructor(private httpClient: HttpClient) {
    this.purchases = PURCHASES;
  }

  ngOnInit() {
    this.httpClient.get<Purchase[]>("api/purchases")
      .subscribe(resp => {
        this.purchases = resp;
      });

    // since the response is coming asynchronosly,
    // we either have to wait or get the data from the backend (which is safer anyway)
    this.httpClient.get<number>("api/purchasesum")
      .subscribe(resp => { this.purchaseSum = resp; })

  }


  onPurchaseDeleteClicked(purchase: Purchase) {
    console.log("Delete Purchase with id: " + purchase.id);

    const params = new HttpParams()
      .set("id", purchase.id.toString());

    this.httpClient.get<Purchase[]>("api/deletePurchase", { params })
      .subscribe(
        resp => { this.purchases = resp; }
      )
  }

  onPurchaseUpdateClicked(purchase) {
    console.log("Update Purchase with id: " + purchase.id);
    console.log(purchase.procmanname);

    const params = new HttpParams()
      .set("id", purchase.id)
      .set("procmanname", purchase.procmanname)
      .set("prodname", purchase.prodname);

    this.httpClient.get<Purchase[]>("api/updatePurchase", { params })
      .subscribe(
        resp => { this.purchases = resp; }
      )
  }

  addMockupData() {
    console.log("Adding some random data");

    this.httpClient.get<Purchase[]>("api/addpurchase")
      .subscribe(
        resp => { this.purchases = resp; }
      )
  }



}

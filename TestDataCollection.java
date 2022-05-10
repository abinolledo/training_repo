package org.ssglobal.training.codes.adt;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TestDataCollection {

	public static void main(String[] args) {
		// ------------------
		//		Invoice
		// ------------------
		// ID  | Vendor Name | Date Invoiced   | Total
		// 101 | McDonalds   | April 10 , 2021 | 80900.00
		// 102 | Jollibee    | April 11, 2022  | 100900.00
		
		List<Invoice> records = new ArrayList<>(); // replace the placeholder type with pojo
//		records.add(101);
//		records.add("McDonalds");
//		records.add(LocalDate.of(2021, 04, 10));
		
		Invoice rec1 = new Invoice();
		rec1.setId(101);
		rec1.setVendorName("McDonalds");
		rec1.setDateInvoiced(LocalDate.of(2021, 04, 10));
		rec1.setTotal(80900.00);
		records.add(rec1);
		
		Invoice rec2 = new Invoice();
		rec2.setId(102);
		rec2.setVendorName("Jollibee");
		rec2.setDateInvoiced(LocalDate.of(2022, 04, 11));
		rec2.setTotal(100900.00);
		records.add(rec2);
		
		Invoice rec3 = new Invoice();
		rec3.setId(103);
		rec3.setVendorName("KFC");
		rec3.setDateInvoiced(LocalDate.of(2022, 03, 21));
		rec3.setTotal(200000.00);
		records.add(rec3);
		
		
		// Two problems
		
		// hindi masort, kelangan daw ng feature na sorting mechanism nyeta sia
		
		Collections.sort(records, new IdComparator());
		
		for(Invoice inv : records) {
			System.out.format("%d %s %s %.3f \n",inv.getId(), inv.getVendorName(), inv.getDateInvoiced(), inv.getTotal());
		}
		
		Collections.sort(records, new VendorNameComparator());
		
		for(Invoice inv : records) {
			System.out.format("%d %s %s %.3f \n",inv.getId(), inv.getVendorName(), inv.getDateInvoiced(), inv.getTotal());
		}
		
		
//		System.out.println(records);
		records.sort(new IdComparator());
		for(Invoice inv : records) {
//			System.out.format("%d %s %s %.3f \n",inv.getId(), inv.getVendorName(), inv.getDateInvoiced(), inv.getTotal());
			System.out.println("-----------------------------");
			System.out.println(inv);
		}
		
	}

}

// Comparator Requirements:
// 1. Avoid using Comparator with Comparable
// 2. Create a utility class for Comparator
// 3. Choose an attribute(s) to apply Comparator with 

// class Invoice implements Comparable<Invoice> { 
class Invoice {
	private Integer id;
	private String vendorName;
	private LocalDate dateInvoiced;
	private Double total;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getVendorName() {
		return vendorName;
	}
	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}
	public LocalDate getDateInvoiced() {
		return dateInvoiced;
	}
	public void setDateInvoiced(LocalDate dateInvoiced) {
		this.dateInvoiced = dateInvoiced;
	}
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.join(" ", String.valueOf(id), vendorName, dateInvoiced.toString(), String.valueOf(total));
	}

	
	// comparing ids
//	public int compareTo(Invoice o) {
		
//		if(id.compareTo(o.getId()) == 0) {
//			return 0;
//		} else if (id.compareTo(o.getId()) > 0) {
//			return 2;
//		} else {
//			return -2;
//		}
//	}
	/*
	public int compareTo(Invoice o) {
		
		if(vendorName.compareTo(o.getVendorName()) == 0) {
			return 0;
		} else if (vendorName.compareTo(o.getVendorName()) > 0) {
			return 2;
		} else {
			return -2;
		}
	}
		*/
	
	
}


// pag isa lng naman gagamit, ilagay sa baba at default
// IdComparator is attributeComparator

class IdComparator implements Comparator<Invoice> {

	@Override
	public int compare(Invoice o1, Invoice o2) {
		if (o1.getId().compareTo(o2.getId()) == 0) {
			return 0;
		} else if (o1.getId().compareTo(o2.getId()) > 0) {
			return 2;
		} else {
			return -2;
		}
	}
	
}

class VendorNameComparator implements Comparator<Invoice> {

	@Override
	public int compare(Invoice o1, Invoice o2) {
		if (o1.getVendorName().compareTo(o2.getVendorName()) == 0) {
			return 0;
		} else if (o1.getVendorName().compareTo(o2.getVendorName()) > 0) {
			return 2;
		} else {
			return -2;
		}
	}
	
}
package main

import "fmt"

type Department interface {
	execute(*Patient)
	setNext(Department)
}

type Patient struct {
	name              string
	registrationDone  bool
	doctorCheckUpDone bool
	medicineDone      bool
	paymentDone       bool
}

type Reception struct {
	next Department
}

func (r *Reception) execute(p *Patient) {
	if p.registrationDone {
		fmt.Println("Patient registration already done")
		if r.next != nil {
			r.next.execute(p)
		}
		return
	}
	fmt.Println("Reception registering patient")
	p.registrationDone = true
	if r.next != nil {
		r.next.execute(p)
	}
}

func (r *Reception) setNext(next Department) {
	r.next = next
}

type Doctor struct {
	next Department
}

func (d *Doctor) execute(p *Patient) {
	if p.doctorCheckUpDone {
		fmt.Println("Doctor checkup already done")
		if d.next != nil {
			d.next.execute(p)
		}
		return
	}
	fmt.Println("Doctor checkup already done")
	p.doctorCheckUpDone = true
	if d.next != nil {
		d.next.execute(p)
	}
}

func (d *Doctor) setNext(next Department) {
	d.next = next
}

type Medical struct {
	next Department
}

func (m *Medical) execute(p *Patient) {
	if p.medicineDone {
		fmt.Println("Medicine already given to patient")
		if m.next != nil {
			m.next.execute(p)
		}
		return
	}
	fmt.Println("Medical giving medicine to patient")
	p.medicineDone = true
	if m.next != nil {
		m.next.execute(p)
	}
}

func (m *Medical) setNext(next Department) {
	m.next = next
}

type Cashier struct {
	next Department
}

func (c *Cashier) execute(p *Patient) {
	if p.paymentDone {
		fmt.Println("Payment Done")
		if c.next != nil {
			c.next.execute(p)
		}
		return
	}
	fmt.Println("Cashier getting money from patient patient")
	p.paymentDone = true
	if c.next != nil {
		c.next.execute(p)
	}
}

func (c *Cashier) setNext(next Department) {
	c.next = next
}

func main() {

	cashier := &Cashier{}
	cashier.setNext(nil)

	//Set next for medical department
	medical := &Medical{}
	medical.setNext(cashier)

	//Set next for doctor department
	doctor := &Doctor{}
	doctor.setNext(medical)

	//Set next for reception department
	reception := &Reception{}
	reception.setNext(doctor)

	patient := &Patient{name: "abc"}
	//Patient visiting
	reception.execute(patient)
}

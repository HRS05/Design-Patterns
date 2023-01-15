package main

import "fmt"

type ITransport interface {
	setServiceProviderName(name string)
	setPathDistance(power int)
	getServiceProviderName() string
	getPathDistance() int
}

type Transport struct {
	serviceProviderName string
	pathDistance        int
}

func (g *Transport) setServiceProviderName(name string) {
	g.serviceProviderName = name
}

func (g *Transport) getServiceProviderName() string {
	return g.serviceProviderName
}

func (g *Transport) setPathDistance(power int) {
	g.pathDistance = power
}

func (g *Transport) getPathDistance() int {
	return g.pathDistance
}

type TruckTransport struct {
	Transport
}

func newTruckTransport() ITransport {
	return &TruckTransport{
		Transport: Transport{
			serviceProviderName: "Truck service privated limited",
			pathDistance:        774839,
		},
	}
}

type ShipTransport struct {
	Transport
}

func newShipTransport() ITransport {
	return &ShipTransport{
		Transport: Transport{
			serviceProviderName: "Ship service privated limited",
			pathDistance:        39928830,
		},
	}
}

type AeroplaneTransport struct {
	Transport
}

func newAeroplaneTransport() ITransport {
	return &AeroplaneTransport{
		Transport: Transport{
			serviceProviderName: "Aeroplane service privated limited",
			pathDistance:        399200093874,
		},
	}
}

func getTransport(transportType string) (ITransport, error) {
	if transportType == "truck" {
		return newTruckTransport(), nil
	}
	if transportType == "ship" {
		return newShipTransport(), nil
	}
	if transportType == "aeroplane" {
		return newAeroplaneTransport(), nil
	}
	return nil, fmt.Errorf("Wrong transport service type passed")
}

func main() {
	truck, _ := getTransport("truck")
	ship, _ := getTransport("ship")
	aeroplane, _ := getTransport("aeroplane")

	printDetails(truck)
	printDetails(ship)
	printDetails(aeroplane)

}

func printDetails(g ITransport) {
	fmt.Printf("Transport Service provider name: %s", g.getServiceProviderName())
	fmt.Println()
	fmt.Printf("Distance travelled: %d", g.getPathDistance())
	fmt.Println()
}

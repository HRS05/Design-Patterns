package main

import "fmt"

type ITrackSuit interface {
	getTshirt() ITshirt
	getLower() ILower
	getUpper() IUpper
}

func getTrackSuit(brand string) (ITrackSuit, error) {
	if brand == "adidas" {
		return &Adidas{}, nil
	}

	if brand == "nike" {
		return &Nike{}, nil
	}

	return nil, fmt.Errorf("Wrong brand type passed")
}

type Adidas struct {
}

func (a *Adidas) getLower() ILower {
	return &AdidasLower{
		Lower: Lower{
			logo: "adidas",
			size: 14,
		},
	}
}

func (a *Adidas) getTshirt() ITshirt {
	return &AdidasTshirt{
		Tshirt: Tshirt{
			logo: "adidas",
			size: 14,
		},
	}
}

func (a *Adidas) getUpper() IUpper {
	return &AdidasUpper{
		Upper: Upper{
			logo: "adidas",
			size: 14,
		},
	}
}

type Nike struct {
}

func (n *Nike) getLower() ILower {
	return &NikeLower{
		Lower: Lower{
			logo: "nike",
			size: 14,
		},
	}
}

func (n *Nike) getTshirt() ITshirt {
	return &NikeTshirt{
		Tshirt: Tshirt{
			logo: "nike",
			size: 14,
		},
	}
}

func (n *Nike) getUpper() IUpper {
	return &NikeUpper{
		Upper: Upper{
			logo: "nike",
			size: 14,
		},
	}
}

type ILower interface {
	setLogo(logo string)
	setSize(size int)
	getLogo() string
	getSize() int
}

type Lower struct {
	logo string
	size int
}

func (s *Lower) setLogo(logo string) {
	s.logo = logo
}

func (s *Lower) getLogo() string {
	return s.logo
}

func (s *Lower) setSize(size int) {
	s.size = size
}

func (s *Lower) getSize() int {
	return s.size
}

type AdidasLower struct {
	Lower
}
type NikeLower struct {
	Lower
}

type ITshirt interface {
	setLogo(logo string)
	setSize(size int)
	getLogo() string
	getSize() int
}

type Tshirt struct {
	logo string
	size int
}

func (s *Tshirt) setLogo(logo string) {
	s.logo = logo
}

func (s *Tshirt) getLogo() string {
	return s.logo
}

func (s *Tshirt) setSize(size int) {
	s.size = size
}

func (s *Tshirt) getSize() int {
	return s.size
}

type AdidasTshirt struct {
	Tshirt
}
type NikeTshirt struct {
	Tshirt
}

type IUpper interface {
	setLogo(logo string)
	setSize(size int)
	getLogo() string
	getSize() int
}

type Upper struct {
	logo string
	size int
}

func (s *Upper) setLogo(logo string) {
	s.logo = logo
}

func (s *Upper) getLogo() string {
	return s.logo
}

func (s *Upper) setSize(size int) {
	s.size = size
}

func (s *Upper) getSize() int {
	return s.size
}

type AdidasUpper struct {
	Upper
}
type NikeUpper struct {
	Upper
}

func main() {
	adidasFactory, _ := getTrackSuit("adidas")
	nikeFactory, _ := getTrackSuit("nike")
	printDetails(adidasFactory)
	printDetails(nikeFactory)

}

func printDetails(suit ITrackSuit) {
	fmt.Println("Lower details")
	lower := suit.getLower()
	fmt.Println("Logo: %s", lower.getLogo())
	fmt.Println("Size: %d", lower.getSize())
	fmt.Println("Tshirt details")
	tshirt := suit.getTshirt()
	fmt.Println("Logo: %s", tshirt.getLogo())
	fmt.Println("Size: %d", tshirt.getSize())
	fmt.Println("Upper details")
	upper := suit.getTshirt()
	fmt.Println("Logo: %s", upper.getLogo())
	fmt.Println("Size: %d", upper.getSize())
}

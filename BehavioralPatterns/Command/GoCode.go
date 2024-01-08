package main

import "fmt"

type Command interface {
	execute()
}

// button
type Button struct {
	command Command
}

func (b *Button) press() {
	b.command.execute()
}

// on command
type OnCommand struct {
	device Device
}

func (c *OnCommand) execute() {
	c.device.on()
}

// off command
type OffCommand struct {
	device Device
}

func (c *OffCommand) execute() {
	c.device.off()
}

// device
type Device interface {
	on()
	off()
}

// TV
type Tv struct {
	isRunning bool
}

func (t *Tv) on() {
	t.isRunning = true
	fmt.Println("Turning tv on")
}

func (t *Tv) off() {
	t.isRunning = false
	fmt.Println("Turning tv off")
}

// main function
func main() {
	tv := &Tv{}

	onCommand := &OnCommand{
		device: tv,
	}

	offCommand := &OffCommand{
		device: tv,
	}

	onButton := &Button{
		command: onCommand,
	}
	onButton.press()

	offButton := &Button{
		command: offCommand,
	}
	offButton.press()
}

#About
This personal project is used for a small POC where a physical lock can be controlled over HTTP.
A servo motor is controlled by turning it to an open or a closed state.
I use the Pi4J library and Java Version 11 (but lower should also be supported)
##Used components (for reference)
 - Rpi3B
 - Servo motor TowerPro MG996R (or TowerPro SG90)
 
#Build
- mvn package

#Run project
sudo java -jar target/pi4servo-1.0-SNAPTSHOT.jar

#Usage
##Set servo to open
http://localhost:9898/open
##set servo to closed
http://localhost:9898/closed
##testing
http://localhost:9898/test/{pwmValue}
- where pwmValue is between 40-260


#PI GPIO -> Servo wiring 
| Rpi Pin | Servo pin | wire color(*) |   |   |
|--------|-------------------|--------|---|---|
| 5V     | VCC               | red    |   |   |
| GROUND | GROUND            | Brown  |   |   |
| GPIO 1 | Pulse signal wire | Orange |   |   |
(*)colors can differ depending on servo type

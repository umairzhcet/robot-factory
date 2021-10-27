# robot-factory

At Robot Factory Inc. we sell configurable Robots, you can configure one for us to manufacture it.

When ordering a robot, a customer must configure the following parts:
- Face (Humanoid, LCD or Steampunk)
- Material (Bioplastic or Metallic)
- Arms (Hands or Grippers)
- Mobility (Wheels, Legs or Tracks)

An order will be valid if it contains one, and only one, part of face, material, arms and mobility.

If an order is valid and there are enough parts to assemble the robot:
- The priced order should be calculated
- The parts should be reserved to produce the robot later on
- Stock is decreased accordingly

## What to do

Given a stock of:
```bash
Code    Price   Available  Part  						
————————————————————————————————————————————————————
A      10.28     9	       Humanoid Face  
B      24.07     7	       LCD Face
C      13.30     0	       Steampunk Face
D      28.94     1	       Arms with Hands
E      12.39     3	       Arms with Grippers
F      30.77     2	       Mobility with Wheels
G      55.13     15	       Mobility with Legs
H      50.00     7	       Mobility with Tracks
I      90.12	 92	       Material Bioplastic
J      82.31	 15	       Material Metallic
```
*Input*
`HTTP POST /orders { "components": ["I","A","D","F"] }`

*Output*
`201 {"order_id": "some-id", "total": 160.11 }`

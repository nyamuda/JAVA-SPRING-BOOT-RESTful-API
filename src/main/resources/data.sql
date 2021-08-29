INSERT INTO physics_topic values
(default,"kinematics");
set @kinematics=last_insert_id();

INSERT INTO physics_topic values
(default,"dynamics");
set @dynamics=last_insert_id();

INSERT INTO physics_topic values
(default,"Work, Energy And Power");
set @wep=last_insert_id();

INSERT INTO physics_topic values
(default,"electricity");
set @electricity=last_insert_id();

INSERT INTO physics_topic values
(default,"waves");
set @waves=last_insert_id();


INSERT INTO term values
(default,"the time for one complete oscillation","period",@waves);


INSERT INTO term values
(default,"is a pair of forces, equal in magnitude but opposite in direction, whose lines of motion do not coincide.","couple",@dynamics);



INSERT INTO term values
(default,"is the rate of change of its displacement with respect to time.","velocity",@kinematics);



INSERT INTO term values
(default,"is the mechanical transfer of energy to a system or from a system by an external force on it.","Work",@wep);


INSERT INTO term values
(default,"Ampere x second","Coloumb",@electricity);






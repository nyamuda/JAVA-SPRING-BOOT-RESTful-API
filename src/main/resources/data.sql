
/* SUBJECTS*/

INSERT INTO subjects values
(default,"Physics");
set @physics=last_insert_id();

INSERT INTO subjects values
(default,"Chemistry");
set @chemistry=last_insert_id();


/* TOPICS */


/* PHYSICS TOPICS*/
INSERT INTO topics values
(default,"kinematics",@physics);
set @kinematics=last_insert_id();

INSERT INTO topics values
(default,"dynamics",@physics);
set @dynamics=last_insert_id();

INSERT INTO topics values
(default,"Work, Energy And Power",@physics);
set @wep=last_insert_id();

INSERT INTO topics values
(default,"electricity",@physics);
set @electricity=last_insert_id();

INSERT INTO topics values
(default,"waves",@physics);
set @waves=last_insert_id();

/*CHEMISTRY TOPICS*/
INSERT INTO topics values
(default,"bonding",@chemistry);
set @bonding=last_insert_id();

INSERT INTO topics values
(default,"atomic_structure",@chemistry);
set @atom=last_insert_id();

INSERT INTO topics values
(default,"electrochemistry",@chemistry);
set @electro=last_insert_id();


/* CURRICULUMS */

INSERT INTO curriculums values
(default,"Cambridge");
set @cam=last_insert_id();

INSERT INTO curriculums values
(default,"CAPS");
set @caps=last_insert_id();



/* TOPIC_CURRICULUM TABLE */

/*CAPS TOPICS */
INSERT INTO topic_curriculum values
(@kinematics,@caps);

INSERT INTO topic_curriculum values
(@dynamics,@caps);

INSERT INTO topic_curriculum values
(@waves,@caps);

INSERT INTO topic_curriculum values
(@wep,@caps);

INSERT INTO topic_curriculum values
(@electricity,@caps);


/* CAMBRIDGE TOPICS */
INSERT INTO topic_curriculum values
(@kinematics,@cam);

INSERT INTO topic_curriculum values
(@dynamics,@cam);

INSERT INTO topic_curriculum values
(@waves,@cam);

INSERT INTO topic_curriculum values
(@wep,@cam);

INSERT INTO topic_curriculum values
(@electricity,@cam);

INSERT INTO topic_curriculum values
(@atom,@cam);

INSERT INTO topic_curriculum values
(@electro,@cam);

INSERT INTO topic_curriculum values
(@bonding,@cam);


/*TERMS*/
INSERT INTO terms values
(default,"period",@waves);
set @period=last_insert_id();

INSERT INTO terms values
(default,"couple",@dynamics);
set @couple=last_insert_id();

INSERT INTO terms values
(default,"velocity",@kinematics);
set @velocity=last_insert_id();

INSERT INTO terms values
(default,"work",@wep);
set @work=last_insert_id();

INSERT INTO terms values
(default,"coulomb",@electricity);
set @coulomb=last_insert_id();

INSERT INTO terms values
(default,"relative atomic mass",@atom);
set @ram=last_insert_id();

INSERT INTO terms values
(default,"first ionisation energy",@bonding);
set @fie=last_insert_id();

INSERT INTO terms values
(default,"Lattice energy",@electro);
set @le=last_insert_id();

/* DEFINITIONS*/

INSERT INTO definitions values
(default,"the time for one complete oscillation",default,@cam,@period);


INSERT INTO  definitions values
(default,"is a pair of forces, equal in magnitude but opposite in direction, whose lines of motion do not coincide.",default,@cam,@couple);



INSERT INTO  definitions values
(default,"is the rate of change of its displacement with respect to time.",default,@cam,@velocity);



INSERT INTO  definitions values
(default,"is the mechanical transfer of energy to a system or from a system by an external force on it.",default,@cam,@work);


INSERT INTO  definitions values
(default,"Ampere x second",default,@cam,@coulomb);

INSERT INTO  definitions values
(default," the  enthalpy change  when  1  mole  of  an ionic compound is formed from its gaseous ions under standard conditions (25 degrees Celcius, 1 a.t.m) ",default,@cam,@le);


INSERT INTO  definitions values
(default,"Is the weighted mean mass of a molecule, compared with one-twelfth of the mass of carbon-12",default,@cam,@ram);

INSERT INTO  definitions values
(default,"The energy required to remove 1 electron from every atom in 1 mole of gaseous atoms to form a mole of gaseous 1+ ions",default,@cam,@fie);
--liquibase formatted sql
--changeset allan:03
--comment: inserts on table movie and movie theater
INSERT INTO VTE.MOVIE(CREATION_DATE, CATEGORY, NAME, SINOPSE) VALUES ('1973-06-01 00:00:00', 'CARTOON', 'BELLADONNA OF SADNESS', 'This well-crafted Japanese animated feature adapts the novel Belladonna by Jules Michelet in a unique manner. The story concerns a love affair, taking place in the Middle Ages, shadowed by witch-trials and the Inquisition. The actual moments of the story are shown in more-or-less still tableaux, but the inner thoughts and feelings of the characters are fully animated.');
INSERT INTO VTE.MOVIE(CREATION_DATE, CATEGORY, NAME, SINOPSE) VALUES ('2014-02-11 00:00:00', 'CARTOON', 'THE JUNGLE BOOK', 'The final animated feature produced under the supervision of Walt Disney is a lively neo-swing musical, loosely based upon the tales of Rudyard Kipling. The story takes place in a tropical jungle where people are conspicuously absent. But one day Bagheera the Panther (voice of Sebastian Cabot) discovers a baby in the wreck of a boat. Feeling pity on the child, Bagheera takes him to be raised with the wolves. Ten years later, the child has grown into Mowgli (voice of Bruce Reitherman). Mowgli discovers that his life is in danger because of the return to the area of Shere Khan the Tiger (voice of George Sanders), whose hatred of humans is such that Mowgli faces certain death if discovered. Bagheera agrees to transport Mowgli to the human village, where he will be safe from Shere Khan. Along the way to the village, night falls and Mowgli and Bagheera almost succumb to the man-eating snake Kaa (voice of Sterling Holloway). Escaping Kaa''s coils, they run into the lock-step military elephant band of Colonel Hathi (voice of J. Pat O''Malley). Afterwards, Mowgli, who doesn''t want to be sent to the human village, runs away from Bagheera and meets up with the fun-loving Baloo the Bear (voice of Phil Harrris). With both Bagheera and Baloo to protect him, Mowgli is saved from several more life-threatening situations -- including a barber-shop quartet of vultures, the crazed King Louie of the Apes (voice of Louis Prima), and Shere Khan himself -- before making it to the village of humans.');
INSERT INTO VTE.MOVIE(CREATION_DATE, CATEGORY, NAME, SINOPSE) VALUES ('2000-12-15 00:00:00', 'CARTOON', 'THE EMPEROR''S NEW GROOVE', 'In a mythical mountain kingdom, arrogant, young Emperor Kuzco is transformed into a llama by his power-hungry advisor, the devious diva Yzma. Stranded in the jungle, Kuzco''s only chance to get back home and reclaim the high life rests with a good-hearted peasant named Pacha. Kuzco''s perfect world becomes a perfect mess as this most unlikely duo must deal with hair-raising dangers, wild comic predicaments, and -- most horrifying of all - each other as they race to return Kuzco to the throne before Yzma tracks them down and finishes him off.');
--rollback DELETE FROM VTE.MOVIE;
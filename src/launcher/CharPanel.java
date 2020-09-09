/**
 * 
 * This stores all the information for The character stories on the launcher.
 * 
 */
package launcher;

import java.awt.CardLayout;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import game.SoundEffect;


public class CharPanel extends JPanel implements ItemListener{

	private CardLayout cardlayout;


	public CharPanel()
	{
		
		final ImageIcon icon_father = new ImageIcon(getClass().getResource("/res/player/Father_Large.png"));
		final ImageIcon icon_longfellow = new ImageIcon(getClass().getResource("/res/player/Professor_Large.png"));
		final ImageIcon icon_jenny = new ImageIcon(getClass().getResource("/res/player/Jenny_Large.png"));
		final ImageIcon icon_heather = new ImageIcon(getClass().getResource("/res/player/Heather_Large.png"));
		final ImageIcon icon_zostra = new ImageIcon(getClass().getResource("/res/player/Madame_Large.png"));
		final ImageIcon icon_vivian = new ImageIcon(getClass().getResource("/res/player/Vivian_Large.png"));
		final ImageIcon icon_zoe = new ImageIcon(getClass().getResource("/res/player/Zoe_Large.png"));
		final ImageIcon icon_missy = new ImageIcon(getClass().getResource("/res/player/Missy_Large.png"));
		final ImageIcon icon_peter = new ImageIcon(getClass().getResource("/res/player/Peter_Large.png"));
		final ImageIcon icon_brandon = new ImageIcon(getClass().getResource("/res/player/Brandon_Large.png"));
		final ImageIcon icon_ox = new ImageIcon(getClass().getResource("/res/player/Ox_Large.png"));
		final ImageIcon icon_darrin = new ImageIcon(getClass().getResource("/res/player/Darrin_Large.png"));
		
		//Character Background Stories
		String father_story = "Father Rhinehardt was born in Munchen, Germany (or Munich, as Americans call it). "
				+ "He moved with his family to America when he was 15 ... and then got beaten up for the next three years. "
				+ "Father Rhinehardt turned to religion for the reasons why people treated him so badly. Eventually, "
				+ "he entered Seminary and became a priest. since that day, long ago, amny people have confessed their"
				+ " sins to him. But there is one man who haunts him, every few years, a stranger who sits in the "
				+ "confessional and whispers of murder and madness. In recent years Father rhinehardt has found "
				+ "he's starting to agree with the madman's arguements. Blood, pain, death--they are all a part "
				+ "of God's plan, are they not?\n\n Father Rhinehardt is familiar with Vivian and Madame Zostra from seeing "
				+ "them at the Something Written bookstore. He know Ox from hearing him confess his petty sins. He "
				+ "also knows Missy from her appearances at Sunday School. More than anything, Father Rhinehardt "
				+ "fears going mad.";
		
		String longfellow_story = "Professor Josiah Longfellow is very proud of his aristocratic roots. His family "
				+ "used to have money .. at least until his father lost it all on gambling and alcohol. The Professor "
				+ "still lives with his aging mother in the rundown Victorian that used to be the finest house in town. "
				+ "His father disappeared one day. Ran out. His mother has a rather large life insurance policy, but "
				+ "of course, he doesn't want to collect on it any time soon, no matter how nice the money would be.\n\n "
				+ "Professor Longfellow knows Ox, Flash, and heather from the university. Brandon is his paperboy. Peter "
				+ "mows the yard and takes care of other petty chores around the house. The Professor's greatest fear "
				+ "is that he will lose everything he has, proving to everyone that he's no better than his deadbeat "
				+ "father.";
		
		String jenny_story = "Jenny is a quiet girl. She loves soccer, but sometimes she's too shy to cooperate with her "
				+ "teammates the way she should. Jenny's greatest pleasure is curling up alone in a tiny place reading "
				+ "a gigantic book--the older the book, the better. The books keep her from dwelling on her mother's "
				+ "disappearance, that day fourteen years ago when Mom went to the store and never came back, leaving "
				+ "Jenny alone. Alone forever.\n\n Jenny's only real friend is caitlyn, Heather's older sister. Jenny "
				+ "also knows Ox, since she grew up only a few doors away from him on Mulberry Lane. And Jenny knows "
				+ "Madame Zostra from the library, a place they both adore. Jenny's greatest fear is being trapped in a "
				+ "crowd or lost out in the open.";
		
		
		String heather_story = "Heather has always been perfect-perfectly petite, perfectly blonde, perfectly polite. "
				+ "Perfect, perfect, perfect. If even the teeniest, tinest thing in her life isn't perfect, it gives"
				+ "Heather a headache. Sometimes her headaches get so bad it feels like something is trying to dig"
				+ "its way out of her skull. But even that doesn't wipe the perfect smile off of her face.\n\n"
				+ "Heather's older sister is friends with Jenny-Why, Heather doesn't really know. After all, Jenny's"
				+ "certainly NOT perfect. Heather knows Flash and Professor Longfellow from school. Vivian is a friend"
				+ "of her movther's, has been for years. Heather's greatest fear is that she isn't actually perfect"
				+ "after all.";
		
		String zostra_story = "Madame Zostra, or 'Belladina' (as her mother named her), has been a tarot and tea-leaf "
				+ "reader since college. She started out working part time sitting in the window of an occult "
				+ "bookstore, but now she has her own home astrology business. Although Madame Zostra reads cards for "
				+ "a living, she won't ever read her own cards. She is terrified that she'll see her own death in the "
				+ "cards, something she can't bear to think about. \n\nMadame Zostra is familiar with Vivian and "
				+ "Father Rhinehardt from seeing them at Vivian's bookstore. Flash is her nephew, and she never fails "
				+ "to buy him birthday and Christmas gifts. She sees Jenny regularly at the library. Zoe's mother "
				+ "comes to Madame Zostra for tarot readings. Madame Zostra is terrified of death ... "
				+ "particularily her own";
		
		String vivian_story = "Vivian's perfect day is to get up late, have coffee and doughnuts, and then ride one of "
				+ "her horses all day. Unfortunately, she doesn't get to spend toom nay days like that, since she's so "
				+ "busy trying to keep her little used book store from going under. Some days she gets so frustrated "
				+ "she just feels like burning the place down, or maybe just burning down the little shed out back "
				+ "... or the school. but she'd never do anything like that. Still, sometimes she has nightmares about "
				+ "striking the match... \n\nVivian is a friend of Heather's mother, Sarah. She also knows Madame Zostra "
				+ "and Father Rhinehardt as customers at her little book store. Something Written. For extra money, "
				+ "Vivian has been babysitting missy Dubourde at least once a month for the past few years. Vivian's "
				+ "greatest fear is of fire ... and her fascination with it.";
		
		String zoe_story = "Zoe likes to play in her room with her dolls. Each doll has its own name, family, history, "
				+ "pets, and everything else a doll needs to be happy. Zoe helps her dolls play out little dramas, "
				+ "mostly happy ones, but sometimes the dolls get mad at each other and hit. Not that Daddies would "
				+ "ever hit Mommies. That doesn't happen. Leastways, you're not supposed to talk about it when it "
				+ "does. So, Zoe plays with her dolls. \n\nFlash is Zoe's cousin, but she doesn't know him real "
				+ "well. Zoe's mom foes to Madame Zostra for tarot card readings. Zoe likes playing with her dolls under "
				+ "the table there. Zoe's gamily sometimes goes camping with Brandon's family. But Zoe's doesn't like it, "
				+ "so she mostly stays in the ten and plays with her dolls. Zoe's greatest fear is of the boogeyman "
				+ "... whovever he is.";
		
		String missy_story = "Missy can't remember wanting to be anything excedpt for a doctor. Her favorite gift ever in "
				+ "the whole wide world was her first doctor's kit. She practices 'medicine' on anyone who will let her. "
				+ "She even cuts up dead frogs and stuff she finds in her yard. but soemtimes that gets bad, and she dreams "
				+ "of dead frogs hip-hoppinh into her bed at night and smothering her. Then she screams. \n\n Missy knows "
				+ "Peter (and his gross bug collection) from school. She knows father Rhinehardt from Sunday school "
				+ "(he talks funny and smells like chocolate). Missy lives in the same neighborhood as Brandon. He delivers "
				+ "her family's paper, but she doesn't really know him. (She thinks he's cute though.) Missy's greatest fear "
				+ "is of dead things coming back to life and hunting her.";
		
		String peter_story = "Peter's two favorite places in the world are the basketball court and under his house. He likes "
				+ "the basketball court because that's where he can play his favorite game. He likes being under the "
				+ "house because it's a great place to hunt for bugs, plus it's a good place to avoid his five older "
				+ "brothers. Sure, all older brothers pick on their younger siblinds, but Peter's brothers really "
				+ "pick on him. But what's a few broken bones among family? Peter loves bugs and wants to be an entomologist "
				+ "when he grows up-- and entomologist who never has to speak to his brothers. \n\n Peter earns extra "
				+ "moeny taking care of Professor Longfellow's yard(and finding cool bugs--bonus!). He knows Missy "
				+ "from school. She likes to do pretend medical exams on him and check out his real broken bones, "
				+ "but she doens't like it when he shows her his bug collection. Peter's greatsest fesr is that he'll "
				+ "get trapped somewhere and never be able to escape.";
		
		String brandon_story = "Brandon loves computers and camping. He takes his new laptop with him wherever he goes. "
				+ "That way he can program AND camp at the same time. Cool. Brandon's never liked playing with regular "
				+ "toys, action figures or that kind of thing. In fact, he hates puppets. He had a clown puppet when he "
				+ "was little, and some mornings when he woke up, he'd find it had moved closer to hom. Once it even had "
				+ "a kitchen knife in its hand. Brandon's pretty sure his big brother, Chris, was messing with him. But "
				+ "he still hates puppets. \n\n Brandon sometimes sees Zoe's gamily when they go camping. Zoe usually "
				+ "hides in the tent with her dolls though. Yuck. Brandon delivers the newspaper to Professor Longfellow "
				+ "(in his big old freaky house) and to Miussy's family. Brandon's greatest feear is of puppets, "
				+ "particularly clown puppets.";
		
		String ox_story = "Ox Bellows was always a big kid. Never got beaten up. always did the beating up ... but only when "
				+ "he had to do it. (Well, except for that one time.) Ox doesn't like to think about that, but the blood and "
				+ "screams creep into his dreams on cold, lonely nights. His great fear is of the dark. \n\nOx has known Jenny "
				+ "since they were kids growing up on Mulberry Lane. He met Porfessor Longfellow at Greenwich University. Ox "
				+ "has known father Rhinehardt all his life. He's been confessing his sins to the priest since he was small "
				+ "(except for that one sin he doesn't like to talk about).";
		
		String darrin_story = "Flash isn't the most original name ever for someone as fast as Darrin. But he likes it. It's "
				+ "comfortable and it fits him, just like his favorite pair of track shoes. Darrin lives to run and runs to live. "
				+ "When he's not running, Darrin feels like there's something coming for him ... something Not Good. Even when he "
				+ "runs, the wind sometimes whispers in his ears, and he swears he can hear the Not Good Thing coming up behind him "
				+ "-- fast. No wonder he's the star of the track team. \n\nFlash knows Jenny from the neighborhood. She's okay, but "
				+ "she's real quiet. He's known Madame Zostra for his entire life. After all, he's her nephew. Zoe's his little cousin, "
				+ "but he's only met her a couple of times. Darrin's greatest fear is that he's going to be caught by the Not Good Thing "
				+ "(whatever it is).";
		
	
		//End stories
		cardlayout = new CardLayout();
		setLayout(cardlayout);
		CharGuiPanel heather = new CharGuiPanel(icon_heather, "Heather Granville", 18, "5'2", 120, "Television, Shopping", "August 2nd", heather_story);
		CharGuiPanel jenny = new CharGuiPanel(icon_jenny, "Jenny LeClerc", 21, "5'7", 142, "Reading, Soccer", "March 4th", jenny_story);
		CharGuiPanel ox = new CharGuiPanel(icon_ox, "Ox Bellows", 23, "6'4", 288, "Football, Shiny Objects", "October 18th", ox_story);
		CharGuiPanel darrin = new CharGuiPanel(icon_darrin, "Darrin 'Flash' Williams", 20, "5'11", 188, "Track, Music, Literature", "June 6th", darrin_story);
		CharGuiPanel vivian = new CharGuiPanel(icon_vivian, "Vivian Lopez", 42, "5'5", 142, "Old Movies, Horses", "January 11th", vivian_story);
		CharGuiPanel zostra = new CharGuiPanel(icon_zostra, "Madame Zostra", 37, "5'0", 150, "Astrology, Cooking, Baseball", "December 10th", zostra_story);
		CharGuiPanel missy = new CharGuiPanel(icon_missy, "Missy Dubourde", 9, "4'2", 62, "Swimming, Medicine", "February 14th", missy_story);
		CharGuiPanel zoe = new CharGuiPanel(icon_zoe, "Zoe Ingstrom", 8, "3'9", 49, "Dolls, Music", "November 5th", zoe_story);
		CharGuiPanel peter = new CharGuiPanel(icon_peter, "Peter Akimoto", 13, "4'11", 98, "Bugs, Basketball", "September 3rd", peter_story);
		CharGuiPanel brandon = new CharGuiPanel(icon_brandon, "Brandon Jaspers", 12, "5'1", 109, "computers, Camping, Hockey", "May 21st", brandon_story);
		CharGuiPanel longfellow = new CharGuiPanel(icon_longfellow, "Professor Longfellow", 56, "5'11", 153, "Gaelic Music, Drama, Wines", "July 27th", longfellow_story);
		CharGuiPanel father = new CharGuiPanel(icon_father, "Father Rhinehardt", 62, "5'9", 185, "Fencing, Gardening", "April 29th", father_story);
		
		JPanel blank = new JPanel();
		blank.setOpaque(false);
		
		
		
		
		//Add components to Card Layoout
		add(heather, "Heather");
		add(jenny, "Jenny");
		add(ox, "Ox");
		add(darrin, "Darrin");
		add(vivian, "Vivian");
		add(zostra, "Zostra");
		add(missy, "Missy");
		add(zoe, "Zoe");
		add(peter, "Peter");
		add(brandon, "Brandon");
		add(longfellow, "Longfellow");
		add(father, "Father");
		add(blank, "Blank");
		
		cardlayout.show(this, "Blank");
		
	}
	
	//show specific panel
	public void show(String str)
	{
		cardlayout.show(this, str);
		
		//Play sound of person
		switch (str)
		{
		case "Heather":
			SoundEffect.CHEER_INTRO_1.play();
			break;
		case "Jenny":
			SoundEffect.CHEER_INTRO_2.play();
			break;
		case "Ox":
			SoundEffect.JOCK_INTRO_2.play();
			break;
		case "Darrin":
			SoundEffect.JOCK_INTRO_1.play();
			break;
		case "Vivian":
			SoundEffect.WOMAN_INTRO_1.play();
			break;
		case "Zostra":
			SoundEffect.WOMAN_INTRO_2.play();
			break;
		case "Missy":
			SoundEffect.GIRL_INTRO_1.play();
			break;
		case "Zoe":
			SoundEffect.GIRL_INTRO_2.play();
			break;
		case "Peter":
			SoundEffect.BOY_INTRO_1.play();
			break;
		case "Brandon":
			SoundEffect.BOY_INTRO_2.play();
			break;
		case "Longfellow":
			SoundEffect.OLD_INTRO_1.play();
			break;
		case "Father":
			SoundEffect.OLD_INTRO_2.play();
			break;
		}
		
	}
	
	//Check for item change
	public void itemStateChanged(ItemEvent evt) {
        CardLayout cl = (CardLayout)(this.getLayout());
        cl.show(this, (String)evt.getItem());
    }
}

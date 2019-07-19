package com.music.utils;

import com.music.database.dao.AlbumDao;
import com.music.database.dao.BandDao;
import com.music.database.dao.SongsDao;
import com.music.database.dbRun.DbManager;
import com.music.database.models.*;
import com.music.utils.exceptions.ApplicationException;

public class FillDatabase {

    public static  void fillDatabase(){

        // Gatunki
        Genres genres = new Genres();
        genres.setName("Rock");

        Genres genres1 = new Genres();
        genres1.setName("Rap");

        Genres genres2 = new Genres();
        genres2.setName("Disco");

        // Bandy
        Band band = new Band();
        band.setGenres(genres);
        band.setName("Linkin Park");

        Band band1 = new Band();
        band1.setGenres(genres1);
        band1.setName("Eminem");

        Band band2 = new Band();
        band2.setGenres(genres2);
        band2.setName("Akcent");

        // Albumy /////////////////////////////////////////////////////


        // Albumy Linkin Park //////////////////////////////////////
        Album album = new Album();
        album.setBand(band);
        album.setName("Meteora");

        Album albumLP = new Album();
        albumLP.setBand(band);
        albumLP.setName("Hybrid Theory");

        // Albumy Eminem ///////////////////////////////////
        Album album1 = new Album();
        album1.setBand(band1);
        album1.setName("The Slim Shady");

        // Albumy Akcent
        Album album2 = new Album();
        album2.setBand(band2);
        album2.setName("Przekorny Los");

        //Piosenki Linkin Park

        Songs songsLP = new Songs();
        songsLP.setAlbum(album);
        songsLP.setName("Don't Stay");
        songsLP.setTextt("Sometimes I need to remember just to breathe\n" +
                "Sometimes I need you to stay away from me\n" +
                "Sometimes I'm in disbelief, I didn't know\n" +
                "Somehow I need you to go\n" +
                "Don't stay\n" +
                "Forget our memories\n" +
                "Forget our possibilities\n" +
                "What you were changing me into\n" +
                "(Just give me myself back and)\n" +
                "Don't stay\n" +
                "Forget our memories\n" +
                "Forget our possibilities\n" +
                "Take all your faithlessness with you\n" +
                "(Just give me myself back and)\n" +
                "Don't stay\n" +
                "Sometimes I feel like I trusted you too well\n" +
                "Sometimes I just feel like screaming at myself\n" +
                "Sometimes I'm in disbelief, I didn't know\n" +
                "Somehow I need to be alone\n" +
                "Don't stay\n" +
                "Forget our memories\n" +
                "Forget our possibilities\n" +
                "What you were changing me into\n" +
                "(Just give me myself back and)\n" +
                "Don't stay\n" +
                "Forget our memories\n" +
                "Forget our possibilities");


        Songs songsLP1 = new Songs();
        songsLP1.setAlbum(album);
        songsLP1.setName("Somewhere I Belong");
        songsLP1.setTextt("When this began,\n" +
                "I had nothing to say \n" +
                "And I'd get lost in the nothingness inside of me\n" +
                "(I was confused)\n" +
                "And I let it all out to find that I'm not the only person with these things in mind (inside of me)\n" +
                "But all the vacancy the words revealed\n" +
                "Is the only real thing that I got left to feel (nothing to lose)\n" +
                "Just stuck, hollow and alone\n" +
                "And the fault is my own,\n" +
                "And the fault is my own\n" +
                "\n" +
                "I want to heal, I want to feel,\n" +
                "What I thought was never real\n" +
                "I want to let go of the pain I felt so long (erase all the pain 'til it's gone)\n" +
                "I want to heal, I want to feel\n" +
                "Like I'm close to something real\n" +
                "I want to find something I've wanted all along\n" +
                "Somewhere I belong\n" +
                "\n" +
                "And I've got nothing to say\n" +
                "I can't believe I didn't fall right down on my face (I was confused) \n" +
                "Looking everywhere only to find that it's not the way I had imagined it all in my mind (so what am I?)\n" +
                "What do I have but negativity?\n" +
                "'Cause I can't justify the way everyone is looking at me (nothing to lose)\n" +
                "Nothing to gain, hollow and alone\n" +
                "And the fault is my own,\n" +
                "And the fault is my own\n" +
                "\n" +
                "I want to heal, I want to feel,\n" +
                "What I thought was never real\n" +
                "I want to let go of the pain I've held so long (erase all the pain 'till it's gone)\n" +
                "I want to heal, I want to feel\n" +
                "Like I'm close to something real\n" +
                "I want to find something I've wanted all along\n" +
                "Somewhere I belong");

        Songs songsLP2 = new Songs();
        songsLP2.setAlbum(album);
        songsLP2.setName("Numb");
        songsLP2.setTextt("I'm tired of being what you want me to be\n" +
                "Feeling so faithless, lost under the surface\n" +
                "I don't know what you're expecting of me\n" +
                "Put under the pressure of walking in your shoes\n" +
                "Caught in the undertow, just caught in the undertow\n" +
                "Every step that I take is another mistake to you\n" +
                "Caught in the undertow, just caught in the undertow\n" +
                "\n" +
                "I've become so numb, I can't feel you there\n" +
                "Become so tired, so much more aware\n" +
                "By becoming this all I want to do\n" +
                "Is be more like me and be less like you\n" +
                "\n" +
                "Can't you see that you're smothering me?\n" +
                "Holding too tightly, afraid to lose control\n" +
                "'Cause everything that you thought I would be\n" +
                "Has fallen apart right in front of you\n" +
                "Caught in the undertow, just caught in the undertow\n" +
                "Every step that I take is another mistake to you\n" +
                "Caught in the undertow, just caught in the undertow\n" +
                "And every second I waste is more than I can take!\n" +
                "\n" +
                "I've become so numb, I can't feel you there\n" +
                "Become so tired, so much more aware\n" +
                "By becoming this all I want to do\n" +
                "Is be more like me and be less like you\n" +
                "\n" +
                "And I know I may end up failing too\n" +
                "But I know you were just like me with someone disappointed in you\n" +
                "\n" +
                "I've become so numb, I can't feel you there\n" +
                "Become so tired, so much more aware\n" +
                "By becoming this all I want to do\n" +
                "Is be more like me and be less like you\n" +
                "\n" +
                "I've become so numb, I can't feel you there\n" +
                "I'm tired of being what you want me to be\n" +
                "I've become so numb, I can't feel you there\n" +
                "I'm tired of being what you want me to be");

        Songs songsLP3 = new Songs();
        songsLP3.setAlbum(album);
        songsLP3.setName("Faint");
        songsLP3.setTextt("I am a little bit of loneliness, a little bit of disregard\n" +
                "Handful of complaints but I can't help the fact\n" +
                "That everyone can see these scars\n" +
                "I am what I want you to want, what I want you to feel\n" +
                "But it's like no matter what I " +
                "do\n, I can't convince you \n" +
                "To just believe this is real\n" +
                "So I, let go watching you turn your back like you always do\n" +
                "Face away and pretend I'm not\n" +
                "But I'll be here 'cause you're all that I've got\n" +
                "\n" +
                "I can't feel the way I did before\n" +
                "Don't turn your back on me\n" +
                "I won't be ignored\n" +
                "Time won't heal this damage anymore\n" +
                "Don't turn your back on me I won't be ignored\n" +
                "\n" +
                "I am, a little bit insecure, a little unconfident\n" +
                "'Cause you don't understand I do what I can\n" +
                "But sometimes I don't make sense\n" +
                "I am, what you never want to say,\n but I've never had a doubt\n" +
                "It's like no matter \nwhat I do I can't convince " +
                "you for once just to hear me out\n" +
                "So I, let go watching you turn your back like you always do\n" +
                "You face away and pretend I'm not\n" +
                "But I'll be here 'cause you're all that I've got\n" +
                "\n" +
                "I can't feel the way I did before\n" +
                "Don't turn your back on me\n" +
                "I won't be ignored\n" +
                "Time won't heal this damage anymore\n" +
                "Don't turn your back on me I won't be ignored");

        Songs songslinkin = new Songs();
        songslinkin.setAlbum(albumLP);
        songslinkin.setName("Papercut");
        songslinkin.setTextt("Why does it feel like night today?\n" +
                "Something in the air's not right today\n" +
                "Why am I so uptight today?\n" +
                "Paranoia's all I got left\n" +
                "I don't know what stressed me first\n" +
                "Or how the pressure was fed\n" +
                "But I know just what it feels like\n" +
                "To have a voice in the back of my head\n" +
                "Like a face that I hold inside\n" +
                "A face that awakes when I close my eyes\n" +
                "A face watches every time I lie\n" +
                "A face that laughs every time I fall\n" +
                "(It watches everything)\n" +
                "So I know now when it's time to sink or swim\n" +
                "That the face inside is hearing me\n" +
                "Right beneath my skin\n" +
                "\n" +
                "It's like I'm paranoid lookin' over my back\n" +
                "It's like a whirlwind inside of my head\n" +
                "It's like I can't stop what I'm hearing within\n" +
                "It's like the face inside is right beneath my skin\n" +
                "\n" +
                "I know I've got a face in me\n" +
                "Points out all my mistakes to me\n" +
                "You've got a face on the inside too\n" +
                "Your paranoia's probably worse\n" +
                "I don't know what set me off first but I know what I can't stand\n" +
                "Everybody acts like the fact of the matter is\n" +
                "I can't add up to what you can but\n" +
                "Everybody has a face that they hold inside\n" +
                "A face that awakes when I close my eyes\n" +
                "A face that watches every time they lie\n" +
                "A face that laughs every time they fall\n" +
                "(It watches everything)\n" +
                "So you know that when it's time to sink or swim\n" +
                "That the face inside is watching you too\n" +
                "Right inside your skin\n" +
                "\n" +
                "It's like I'm paranoid lookin' over my back\n" +
                "It's like a whirlwind inside of my head\n" +
                "It's like I can't stop what I'm hearing within\n" +
                "It's like the face inside is right beneath my skin\n" +
                "It's like I'm paranoid lookin' over my back\n" +
                "It's like a whirlwind inside of my head\n" +
                "It's like I can't stop what I'm hearing within\n" +
                "It's like the face inside is right beneath my skin\n" +
                "\n" +
                "The face inside is right beneath your skin\n" +
                "The face inside is right beneath your skin\n" +
                "The face inside is right beneath your skin\n" +
                "\n" +
                "The sun goes down\n" +
                "I feel the light betray me\n" +
                "The sun goes down\n" +
                "I feel the light betray me\n" +
                "\n" +
                "It's like I'm paranoid lookin' over my back\n" +
                "It's like a whirlwind inside of my head\n" +
                "It's like I can't stop what I'm hearing within\n" +
                "It's like the face inside is right beneath my skin\n" +
                "It's like I'm paranoid lookin' over my back\n" +
                "It's like a whirlwind inside of my head\n" +
                "It's like I can't stop what I'm hearing within\n" +
                "It's like I can't stop what I'm hearing within\n" +
                "It's like I can't stop what I'm hearing within\n" +
                "It's like the face inside is right beneath my skin");

        Songs songsLinkin1 = new Songs();
        songsLinkin1.setAlbum(albumLP);
        songsLinkin1.setName("One Step Closer");
        songsLinkin1.setTextt("I cannot take this anymore\n" +
                "I'm saying everything I've said before\n" +
                "All these words they make no sense\n" +
                "I find bliss in ignorance\n" +
                "Less I hear the less you'll say\n" +
                "But you'll find that out anyway\n" +
                "Just like before\n" +
                "\n" +
                "Everything you say to me\n" +
                "Takes me one step closer to the edge\n" +
                "And I'm about to break\n" +
                "I need a little room to breathe\n" +
                "'Cause I'm one step closer to the edge\n" +
                "And I'm about to break\n" +
                "\n" +
                "I find the answers aren't so clear\n" +
                "Wish I could find a way to disappear\n" +
                "All these thoughts they make no sense\n" +
                "I find bliss in ignorance\n" +
                "Nothing seems to go away\n" +
                "Over and over again\n" +
                "Just like before\n" +
                "\n" +
                "Everything you say to me\n" +
                "Takes me one step closer to the edge\n" +
                "And I'm about to break\n" +
                "I need a little room to breathe\n" +
                "'Cause I'm one step closer to the edge\n" +
                "And I'm about to break\n" +
                "\n" +
                "Everything you say to me\n" +
                "Takes me one step closer to the edge\n" +
                "And I'm about to break\n" +
                "I need a little room to breathe\n" +
                "'Cause I'm one step closer to the edge\n" +
                "And I'm about to, break\n" +
                "\n" +
                "Shut up when I'm talking to you\n" +
                "Shut up, shut up, shut up\n" +
                "Shut up when I'm talking to you\n" +
                "Shut up, shut up, shut up\n" +
                "Shut up, I'm about to break!\n" +
                "\n" +
                "Everything you say to me\n" +
                "Takes me one step closer to the edge\n" +
                "And I'm about to break\n" +
                "I need a little room to breathe\n" +
                "'Cause I'm one step closer to the edge\n" +
                "And I'm about to break\n" +
                "\n" +
                "Everything you say to me\n" +
                "Takes me one step closer to the edge\n" +
                "And I'm about to break\n" +
                "I need a little room to breathe\n" +
                "'Cause I'm one step closer to the edge\n" +
                "And I'm about to, break");

        Songs songsLinkin2 = new Songs();
        songsLinkin2.setAlbum(albumLP);
        songsLinkin2.setName("Crawling");
        songsLinkin2.setTextt("Crawling in my skin\n" +
                "These wounds, they will not heal\n" +
                "Fear is how I fall\n" +
                "Confusing what is real\n" +
                "\n" +
                "There's something inside me that pulls beneath the surface\n" +
                "Consuming, confusing\n" +
                "This lack of self control I fear is never ending\n" +
                "Controlling\n" +
                "I can't seem\n" +
                "To find myself again\n" +
                "My walls are closing in\n" +
                "(Without a sense of confidence I'm convinced\n" +
                "That there's just too much pressure to take)\n" +
                "I've felt this way before\n" +
                "So insecure\n" +
                "\n" +
                "Crawling in my skin\n" +
                "These wounds, they will not heal\n" +
                "Fear is how I fall\n" +
                "Confusing what is real\n" +
                "\n" +
                "Discomfort, endlessly has pulled itself upon me\n" +
                "Distracting, reacting\n" +
                "Against my will I stand beside my own reflection\n" +
                "It's haunting how I can't seem\n" +
                "\n" +
                "To find myself again\n" +
                "My walls are closing in\n" +
                "(Without a sense of confidence I'm convinced\n" +
                "That there's just too much pressure to take)\n" +
                "I've felt this way before\n" +
                "So insecure\n" +
                "\n" +
                "Crawling in my skin\n" +
                "These wounds, they will not heal\n" +
                "Fear is how I fall\n" +
                "Confusing what is real\n" +
                "\n" +
                "Crawling in my skin\n" +
                "These wounds, they will not heal\n" +
                "Fear is how I fall\n" +
                "Confusing, confusing what is real\n" +
                "\n" +
                "There's something inside me that pulls beneath the surface\n" +
                "Consuming (confusing what is real)\n" +
                "This lack of self control I fear is never ending\n" +
                "Controlling (confusing what is real)");

        Songs songsLinkin3 = new Songs();
        songsLinkin3.setAlbum(albumLP);
        songsLinkin3.setName("In the End");
        songsLinkin3.setTextt("It starts with one thing\n" +
                "I don't know why\n" +
                "It doesn't even matter how hard you try\n" +
                "Keep that in mind\n" +
                "I designed this rhyme\n" +
                "To explain in due time\n" +
                "All I know\n" +
                "Time is a valuable thing\n" +
                "Watch it fly by as the pendulum swings\n" +
                "Watch it count down to the end of the day\n" +
                "The clock ticks life away\n" +
                "\n" +
                "It's so unreal\n" +
                "Didn't look out below\n" +
                "Watch the time go right out the window\n" +
                "Trying to hold on, but you didn't even know\n" +
                "Wasted it all just to watch you go\n" +
                "I kept everything inside\n" +
                "And even though I tried, it all fell apart\n" +
                "What it meant to me\n" +
                "Will eventually be a memory of a time when\n" +
                "\n" +
                "I tried so hard\n" +
                "And got so far\n" +
                "But in the end\n" +
                "It doesn't even matter\n" +
                "I had to fall\n" +
                "To lose it all\n" +
                "But in the end\n" +
                "It doesn't even matter\n" +
                "\n" +
                "One thing, I don't know why\n" +
                "It doesn't even matter how hard you try\n" +
                "Keep that in mind\n" +
                "I designed this rhyme\n" +
                "To remind myself of a time when\n" +
                "I tried so hard\n" +
                "In spite of the way you were mocking me\n" +
                "Acting like I was part of your property\n" +
                "Remembering all the times you fought with me\n" +
                "I'm surprised it got so\n" +
                "Things aren't the way they were before\n" +
                "You wouldn't even recognize me anymore\n" +
                "Not that you knew me back then\n" +
                "But it all comes back to me in the end\n" +
                "You kept everything inside\n" +
                "And even though I tried, it all fell apart\n" +
                "What it meant to me will eventually be a memory of a time when\n" +
                "\n" +
                "I tried so hard\n" +
                "And got so far\n" +
                "But in the end\n" +
                "It doesn't even matter\n" +
                "I had to fall\n" +
                "To lose it all\n" +
                "But in the end\n" +
                "It doesn't even matter\n" +
                "\n" +
                "I've put my trust in you\n" +
                "Pushed as far as I can go\n" +
                "For all this\n" +
                "There's only one thing you should know\n" +
                "I've put my trust in you\n" +
                "Pushed as far as I can go\n" +
                "For all this\n" +
                "There's only one thing you should know\n" +
                "\n" +
                "I tried so hard\n" +
                "And got so far\n" +
                "But in the end\n" +
                "It doesn't even matter\n" +
                "I had to fall\n" +
                "To lose it all\n" +
                "But in the end\n" +
                "It doesn't even matter");

        // Piosenki Eminem ////////////////////////////////////////////////////////////////////////


        Songs songsEmin = new Songs();
        songsEmin.setAlbum(album1);
        songsEmin.setName("I'm shady");
        songsEmin.setTextt("Who came through with two glocks to terrorize your borough (huh?)" +
                "Told you how to slap dicks and murder your girl (I did!)\n" +
                "Gave you all the finger and told you to sit and twirl\n" +
                "Sold a billion tapes and still screamed, \"Fuck the world!\"\n" +
                "(I'm Slim Shady) so come and kill me while my name's hot\n" +
                "And shoot me twenty-five times in the same spot (Ow!)\n" +
                "I think I got a generation brainwashed\n" +
                "To pop pills and smoke pot 'til they brains rot (uh-oh)\n" +
                "Stop they blood flow until they veins clot\n" +
                "I need a pain shot, and a shot of plain scotch\n" +
                "Purple haze and acid raindrops\n" +
                "Spike the punch at the party and drink pop (gulp gulp)\n" +
                "Shaved my armpits and wore a tank top\n" +
                "Bad Boy, I told you that I can't stop\n" +
                "You gotta make 'em fear you 'fore you make 'em feel you\n" +
                "So everybody buy my shit or I'm a come and kill you\n" +
                "I got mushrooms, I got acid, I got tabs and aspirin tablets\n" +
                "I'm your brother when you need, some good weed to set you free\n" +
                "You know me, I'm your friend, when you need a mini-thin\n" +
                "(I'm Slim Shady) I'm Shady!\n" +
                "I like happy things,\n" +
                "I'm really calm and peaceful (uh-huh huh)\n" +
                "I like birds, bees, I like people\n" +
                "I like funny things\n" +
                "That make me happy and gleeful (he he he)\n" +
                "Like when my teacher sucked my wee-wee in preschool (Woo!)\n" +
                "The ill type, I stab myself with a steel spike\n" +
                "While I blow my brain out, just to see what it feels like\n" +
                "'Cause this is how I am in real life (mm-hm)\n" +
                "I don't want to just die a normal death, I wanna be killed twice (uh-huh)\n" +
                "How you gonna scare somebody with a gun threat\n" +
                "When they high off of drugs they haven't even done yet (Huh?)\n" +
                "So bring the money by tonight, cause your wife\n" +
                "Said this the biggest knife she ever saw in her life (Help me! Help me!)\n" +
                "I try to keep it positive and play it cool\n" +
                "Shoot up the playground and tell the kids to stay in school (Stay in school!)\n" +
                "'Cause I'm the one they can relate to and look up to better\n" +
                "Tonight I think I'll write my biggest fan a fuck you letter\n" +
                "I got mushrooms, I got acid, I got tabs and aspirin tablets\n" +
                "I'm your brother when you need, some good weed to set you free\n" +
                "You know me, I'm your friend, when you need a mini-thin\n" +
                "(I'm Slim Shady) I'm Shady!");




        Songs songsEmin1 = new Songs();
        songsEmin1.setAlbum(album1);
        songsEmin1.setName("If I Had");
        songsEmin1.setTextt("Life\n" +
                "By Marshal Mathers\n" +
                "What is life? \n" +
                "Life is like a big obstacle \n" +
                "In front of your optical to slow you down\n" +
                "And every time you think you gotten past it \n" +
                "It's gonna come back around and tackle you to the damn ground \n" +
                "What are friends? \n" +
                "Friends are people that you think are your friends \n" +
                "But they really your enemies, with secret identities \n" +
                "And disguises, to hide they true colors \n" +
                "So just when you think you close enough to be brothers \n" +
                "They want to come back and cut your throat when you ain't lookin'\n" +
                "What is money? \n" +
                "Money is what makes a man act funny \n" +
                "Money is the root of all evil \n" +
                "Money'll make them same friends come back around \n" +
                "Swearing that they was always down\n" +
                "What is life? \n" +
                "I'm tired of life \n" +
                "I'm tired of backstabbing a** snakes with friendly grins \n" +
                "I'm tired of committing so many sins \n" +
                "Tired of always giving in when this bottle of Henny wins \n" +
                "Tired of never having any ends \n" +
                "Tired of having skinny friends hooked on crack and many things \n" +
                "I'm tired of this DJ playing your s*** when he spins \n" +
                "Tired of not having a deal \n" +
                "Tired of having to deal with the bulls*** without grabbing the steel \n" +
                "Tired of drowning in my sorrow \n" +
                "Tired of having to borrow a dollar for gas to start my Monte Carlo \n" +
                "I'm tired of motherf***ers spraying s*** and dartin' off \n" +
                "I'm tired of jobs startin' off at five fifty an hour \n" +
                "Then this boss wonders why I'm smartin' off \n" +
                "Tired of being fired every time I fart and cough \n" +
                "Tired of having to work as a gas station clerk \n" +
                "For this jerk breathing down my neck driving me berserk \n" +
                "I'm tired of using plastic silverware \n" +
                "Tired of working in Building Square \n" +
                "Tired of not being a millionaire \n" +
                "But if I had a million dollars \n" +
                "I'd buy a damn brewery, and turn the planet into alcoholics\n" +
                "If I had a magic wand, \n" +
                "I'd make the world suck my dick \n" +
                "Without a condom on, \n" +
                "While I'm on the john \n" +
                "If I had a million bucks \n" +
                "It wouldn't be enough, \n" +
                "Because I'd still be out \n" +
                "Robbing armored trucks \n" +
                "If I had one wish \n" +
                "I would ask for a big enough a** \n" +
                "For the whole world to kiss");

        Songs songsEmin2 = new Songs();
        songsEmin2.setAlbum(album1);
        songsEmin2.setName("My Fault");
        songsEmin2.setTextt("I never meant to give you mushrooms girl\n" +
                "I never meant to bring you to my world\n" +
                "Now you sitting in the corner crying\n" +
                "And now its my fault (My fault)\n" +
                "I never meant to give you mushrooms girl\n" +
                "I never meant to bring you to my world\n" +
                "Now you sitting in the corner crying\n" +
                "And now its my fault (My fault)\n" +
                "I went to Johns rave with Ron and Dave\n" +
                "And met a new wave blond babe with half of her head shaved\n" +
                "A nurse aid who came to get laid and tied up\n" +
                "With first aid tape and raped on the first date\n" +
                "Susan an ex heroin addict who just stopped using\n" +
                "She loved booze and alternative music\n" +
                "Told me she was going back to using again\n" +
                "I said wait first try this hallucinogen\n" +
                "Its better then heroin and booze and gin\n" +
                "Come here lets go in here\n" +
                "Who's in the den? (Its me and Kelly)\n" +
                "My bad lets try another room (I don't trust you)\n" +
                "Shut up slut chew up this mushroom\n" +
                "This will help you get in touch with your roots\n" +
                "Walking barefoot butt naked and run in the woods\n" +
                "(Oh hell I might as well try them this party is so drag)\n" +
                "Oh dag I didn't mean for you to eat the whole bag (Uh)\n" +
                "I never meant to give you mushrooms girl\n" +
                "I never meant to bring you to my world\n" +
                "Now you sitting in the corner crying\n" +
                "And now its my fault (My fault)\n" +
                "I never meant to give you mushrooms girl\n" +
                "I never meant to bring you to my world\n" +
                "Now you sitting in the corner crying\n" +
                "And now its my fault (My fault)\n" +
                "Yo Sue (Get away from me I don't know you)\n" +
                "Oh shoot she's tripping (I need to go puke)\n" +
                "I wasn't trying to turn this into something major\n" +
                "I just wanted to make you appreciate nature\n" +
                "Susie stop crying I don't hate ya\n" +
                "The world is not against you\n" +
                "I am sorry your father raped you\n" +
                "So you had your little coochie in your dad's mouth\n" +
                "That ain't no reason to start wiggin' and spaz out\n" +
                "She said (Help me I think I am having a seizure)\n" +
                "I said I am high too bitch\n" +
                "Quit grabbing my t-shirt (Let go)\n" +
                "Would you calm down you are starting to scare me\n" +
                "She said (I am 26 years old and I am not married I don't even have any\n" +
                "Kids and I can't cook)\n" +
                "I am over here Sue\n" +
                "You are talking to the plant\n" +
                "Look we need to get to a hospital\n" +
                "Before it is too late\n" +
                "'Cause I never seen one eat as many 'shrooms as you ate");

        Songs songsEmin3 = new Songs();
        songsEmin3.setAlbum(album1);
        songsEmin3.setName("Role Model");
        songsEmin3.setTextt("Okay\n" +
                "I am going to attempt to drown myself\n" +
                "You can try this at home\n" +
                "You can be just like me\n" +
                "Mic check 1, 2\n" +
                "We recording?\n" +
                "I'm cancerous\n" +
                "So when I dis you, you wouldn't want to answer this\n" +
                "If you responded back with a battle rap you wrote for Canibus\n" +
                "I strangled you to death and I choked you again\n" +
                "And break your fuckin' legs till your bones poke through your skin\n" +
                "You beef wit' me, I'm even the score equally\n" +
                "Take you on Jerry Springer, and beat your ass legally\n" +
                "I get too blunted off the funny home grown\n" +
                "'Cause when I smoke out I hit the trees harder than Sonny Bono\n" +
                "So if I said I never did drugs\n" +
                "That would mean i lie and get fucked more than the President does\n" +
                "Hillary Clinton tried to slap me and call me a pervert\n" +
                "I ripped her fuckin' tonsils out and fed her sherbet\n" +
                "My nerves hurt, and lately I'm on edge\n" +
                "Grabbed Vanilla Ice and ripped out his blond dreads\n" +
                "Every girl I ever went out with has gone les '\n" +
                "Follow me and do exactly what the song says\n" +
                "Smoke weed, take pills, drop outta school, kill people\n" +
                "And drink and jump behind the wheel like it was still legal\n" +
                "I'm dumb enough to walk in a store and steal\n" +
                "So I'm dumb enough to ask for a date wit' Lauryn Hill\n" +
                "Some people only see that I'm white, ignoring skill\n" +
                "'Cause I stand out like a green hat wit a orange bill\n" +
                "But I don't get pissed, y'all don't even see through the mist\n" +
                "How the fuck can I be white, I don't even exist\n" +
                "I get a clean shave, bathe, go to a rave\n" +
                "Die from an overdose and dig myself up out of my grave\n" +
                "My middle finger won't go down, how do I wave\n" +
                "And this is how I'm supposed to teach kids how to behave\n" +
                "Now follow me and do exactly what you see\n" +
                "Don't you want to grow up to be just like me\n" +
                "I slap women and eat shrooms then O.D.\n" +
                "Now don't you want to grow up to be just like me");

        // Piosenki Akcent //////////////////////

        Songs songsAkcent = new Songs();
        songsAkcent.setAlbum(album2);
        songsAkcent.setName("Kochana wierze w milosc");
        songsAkcent.setTextt("Zabiore Cie na dzika plaze,\n" +
                "Gdzie zloty piasek i stada mew.\n" +
                "Wyznam Ci szeptem to o czym marze.\n" +
                "Wyznam Ci szeptem to o czym snie.\n" +
                "Kochana, wierze, wierze w milosc\n" +
                "Kochana, wierze, wierze w nas\n" +
                "I to co nam sie przydarzylo\n" +
                "Niech trwa po wieczny, wieczny czas!\n" +
                "Wiatr sie zaplatal w Twa sukienke.\n" +
                "Pewnie zazdrosci, ze Ciebie mam...\n" +
                "A ja zaspiewam moja piosenke\n" +
                "I w podarunku Tobie ja dam\n" +
                "Kochana, wierze, wierze w milosc\n" +
                "Kochana, wierze, wierze w nas\n" +
                "I to co nam sie przydarzylo\n" +
                "Niech trwa po wieczny, wieczny czas!\n");

        Songs songsAckent1 = new Songs();
        songsAckent1.setAlbum(album2);
        songsAckent1.setName("Skradlas wszystko");
        songsAckent1.setTextt("Ty mi skradlas wszystko, chce bys byla blisko, \n" +
                "Toba opetany caly swiat.\n" +
                "Tone w oczach Twoich, \n" +
                "ogniem plone od nich, \n" +
                "pozwol mi oddychac, tlen mi daj. \n" +
                "Ty mi skradlas wszystko, chce bys byla blisko, \n" +
                "Toba opetany caly swiat.\n" +
                "Tone w oczach Twoich, \n" +
                "ogniem plone od nich, \n" +
                "pozwol mi oddychac, tlen mi daj. \n" +
                "Zenek, slyszysz jaki ma akcent, \n" +
                "to Kubanka czy Portorykanka,\n" +
                "Uno, does, tres, cuatro, \n" +
                "ona ma pasje i ona ma styl,\n" +
                "Z jej pomaranczy sok bym pil,\n" +
                "takie rozkosze, jestem smakoszem, \n" +
                "Rece podnosze w gore, w gore stary,\n" +
                "Ooo jest temat i swita to na nia mowia mamasita mamasita,\n" +
                "To nasza taktyka i bedzie zabawnie\n" +
                "teraz jest taka, to bedzie fajnie,\n" +
                "Patrz siniora w butelke, bejbe hej to Miami.\n");

        Songs songsAkcent2 = new Songs();
        songsAkcent2.setAlbum(album2);
        songsAkcent2.setName("Przekorny Los");
        songsAkcent2.setTextt("Ludzie mowia do mnie przestan martwic sie\n" +
                "Wszak po burzy zawsze slonce lsni.\n" +
                "Zostawila Cie dziewczyna, jest Ci zle\n" +
                "Zaraz nowa milosc wejdzie w moje drzwi\n" +
                "Los chce ze mna grac w pokera,\n" +
                "Raz mi daje raz zabiera\n" +
                "Ja za swoim szczesciem biegne w swiat\n" +
                "Cuda przeciez sie zdarzaja i marzenia sie spelniaja\n" +
                "Los przekorny znowu milosc da\n" +
                "Ludzie mowia, ze po nocy wstaje dzien\n" +
                "Masz nadrobic ten stracony czas.\n" +
                "Dzis juz nowa milosc do mnie smieje sie,\n" +
                "Los mi daje szanse jeszcze jeden raz\n" +
                "Los chce ze mna grac w pokera,\n" +
                "Raz mi daje raz zabiera\n" +
                "Ja za swoim szczesciem biegne w swiat\n" +
                "Cuda przeciez sie zdarzaja i marzenia sie spelniaja\n" +
                "Los przekorny znowu milosc da\n");

        Songs songsAkcent3 = new Songs();
        songsAkcent3.setAlbum(album2);
        songsAkcent3.setName("Przez twe oczy zielone");
        songsAkcent3.setTextt("Odkad zobaczylem ciebie\n" +
                "Nie moge jesc, nie moge spac\n" +
                "Jak do tego doszlo, nie wiem?\n" +
                "Milosc o sobie dala znac\n" +
                "Co poradzic moge na to\n" +
                "Ze milosc przyszla wlasnie dzis.\n" +
                "Ze w sercu mym jest lato,\n" +
                "a w moich myslach jestes ty\n" +
                "Przez twe oczy, te oczy zielone oszalalem!\n" +
                "Gwiazdy chyba twym oczom oddaly caly blask.\n" +
                "A ja serce milosci spragnione ci oddalem\n" +
                "Tak zakochac, zakochac sie mozna tylko raz\n" +
                "W mych ramionach cie ukryje\n" +
                "U stop Ci zloze caly swiat.\n" +
                "Serce me dla ciebie bije\n" +
                "I czeka na twoj maly znak\n" +
                "Jeden usmiech twoj wystarczy\n" +
                "I moje serce gubi rytm\n" +
                "O twa milosc bede walczyl\n" +
                "O milosc walczyc to nie wstyd\n" +
                "Przez twe oczy, te oczy zielone oszalalem\n" +
                "Gwiazdy Chyba twym oczom oddaly caly blask\n" +
                "A ja serce milosci spragnione ci oddalem\n" +
                "Tak zakochac, zakochac sie mozna tylko raz\n");

        BandDao bandDao = new BandDao();
        try {
            bandDao.creatOrUpdate(band);
            bandDao.creatOrUpdate(band1);
            bandDao.creatOrUpdate(band2);
        } catch (ApplicationException e) {
            e.printStackTrace();
        }

        AlbumDao albumDao = new AlbumDao();
        try {
            albumDao.creatOrUpdate(album);
            albumDao.creatOrUpdate(albumLP);
            albumDao.creatOrUpdate(album1);
            albumDao.creatOrUpdate(album2);
        } catch (ApplicationException e) {
            e.printStackTrace();
        }

        SongsDao songsDao = new SongsDao();
        try {
            songsDao.creatOrUpdate(songsLP);
            songsDao.creatOrUpdate(songsLP1);
            songsDao.creatOrUpdate(songsLP2);
            songsDao.creatOrUpdate(songsLP3);
            songsDao.creatOrUpdate(songslinkin);
            songsDao.creatOrUpdate(songsLinkin1);
            songsDao.creatOrUpdate(songsLinkin2);
            songsDao.creatOrUpdate(songsLinkin3);
            songsDao.creatOrUpdate(songsEmin);
            songsDao.creatOrUpdate(songsEmin1);
            songsDao.creatOrUpdate(songsEmin2);
            songsDao.creatOrUpdate(songsEmin3);
            songsDao.creatOrUpdate(songsAkcent);
            songsDao.creatOrUpdate(songsAckent1);
            songsDao.creatOrUpdate(songsAkcent2);
            songsDao.creatOrUpdate(songsAkcent3);
        } catch (ApplicationException e) {
            e.printStackTrace();
        }

        DbManager.closeConnectionSource();


    }
}

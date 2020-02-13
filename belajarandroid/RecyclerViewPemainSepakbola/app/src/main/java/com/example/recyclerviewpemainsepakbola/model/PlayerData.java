package com.example.recyclerviewpemainsepakbola.model;

import java.util.ArrayList;

public class PlayerData {

    //array untuk menaruh data yg akan ditampilkan recycler view
    public static String[][] data = new String[][]{

            {"Frank Lampard",
                    "20 June 1978 (age 41)",
                    "https://upload.wikimedia.org/wikipedia/commons/5/59/Frank_Lampard_2017.jpg",
                    "Frank James Lampard OBE (born 20 June 1978) is an English professional football manager and former player who is the head coach of Premier League club Chelsea. As a player, he is widely considered to have been one of the greatest midfielders of his generation.",
                    "England"},
            {"Bambang Pamungkas",
                    "10 June 1980 (age 39)",
                    "https://upload.wikimedia.org/wikipedia/commons/f/f7/Bambang_Pamungkas_bedah_buku_Kemsetneg.png",
                    "Bambang Pamungkas (born 10 June 1980), also known as Bepe, is a retired Indonesian professional footballer who predominately played for Persija Jakarta and the Indonesia national football team. His natural position is striker. Bambang made his name in South East Asian football when he scored the only goal for Indonesia at the 2002 Tiger Cup semifinal against Malaysia,and was the tournament's top scorer with eight goals.",
                    "Indonesia"},
            {"Ismed Sofyan",
                    "28 August 1979 (age 40)",
                    "https://upload.wikimedia.org/wikipedia/commons/b/b8/Ismed_Sofyan%2C_Keseruan_Sesi_Pemotretan_Para_Pemain_Persija_%28Behind_The_Scene%29.jpg",
                    "Ismed Sofyan (born in Tualang Cut, Aceh 28 August 1979) is an Indonesian footballer who plays for Persija Jakarta in the Liga 1. He normally plays as a wing back or right back and his height is 169 cm. His speciality are free kick taking and assisting with high-curved pass. He has made 53 appearances for the Indonesia national football team.",
                    "Indonesia"},
            {"Cristiano Ronaldo",
                    "5 February 1985 (age 34)",
                    "https://upload.wikimedia.org/wikipedia/commons/8/8c/Cristiano_Ronaldo_2018.jpg",
                    "Cristiano Ronaldo dos Santos Aveiro GOIH ComM (European Portuguese: [kɾiʃˈtjɐnu ʁɔˈnaɫdu]; born 5 February 1985) is a Portuguese professional footballer who plays as a forward for Serie A club Juventus and captains the Portugal national team. Often considered the best player in the world and widely regarded as one of the greatest players of all time, Ronaldo has won five Ballons d'Or and four European Golden Shoes, both of which are records for a European player. He has won 29 trophies in his career, including six league titles, five UEFA Champions Leagues, one UEFA European Championship, and one UEFA Nations League. A prolific goalscorer, Ronaldo holds the records for the most goals scored in the UEFA Champions League (128) and the joint-most goals scored in the UEFA European Championship . He has scored over 700 senior career goals for club and country.",
                    "Portugal"},
            {"Lionel Messi",
                    "24 June 1987 (age 32)",
                    "https://upload.wikimedia.org/wikipedia/commons/c/c1/Lionel_Messi_20180626.jpg",
                    "Lionel Andrés Messi Cuccittini (Spanish pronunciation: [ljoˈnel anˈdɾez ˈmesi] (About this soundlisten);[A] born 24 June 1987) is an Argentine professional footballer who plays as a forward and captains both Spanish club Barcelona and the Argentina national team. Often considered the best player in the world and widely regarded as one of the greatest players of all time, Messi has won a record six Ballon d'Or awards, and a record six European Golden Shoes. He has spent his entire professional career with Barcelona, where he has won a club-record 34 trophies, including ten La Liga titles, four UEFA Champions League titles and six Copas del Rey. A prolific goalscorer and a creative playmaker, Messi holds the records for most goals in La Liga (432), a La Liga and European league season (50), most hat-tricks in La Liga (35) and the UEFA Champions League (8), and most assists in La Liga (174) and the Copa América (13). He has scored over 700 senior career goals for club and country.",
                    "Argentina"},
            {"Kaka",
                    "22 April 1982 (age 37)",
                    "https://upload.wikimedia.org/wikipedia/commons/6/6d/Kak%C3%A1_visited_Stadium_St._Petersburg.jpg",
                    "Ricardo Izecson dos Santos Leite (Brazilian Portuguese: [hiˈkaɾdu iˈzɛksõ duˈsɐ̃tus ˈlejt͡ʃi]; born 22 April 1982), commonly known as Kaká (Portuguese: [kaˈka] (About this soundlisten)) or Ricardo Kaká, is a Brazilian retired professional footballer who played as an attacking midfielder. Owing to his performances as a playmaker at Milan, Kaká is widely considered one of the best players of his generation. With success at club and international level, he is one of eight players to have won the FIFA World Cup, the UEFA Champions League and the Ballon d'Or.",
                    "Brazil"},
            {"John Terry",
                    "7 December 1980 (age 39)",
                    "https://upload.wikimedia.org/wikipedia/commons/c/ce/John-Terry2.jpg",
                    "John George Terry (born 7 December 1980) is an English professional football coach and former player who played as a centre back. He was previously captain of Chelsea, the England national team and Aston Villa; he is the assistant head coach at the latter.",
                    "England"},
            {"Boaz Solossa",
                    "16 March 1986 (age 33)",
                    "https://disk.mediaindonesia.com/thumbs/1200x-/news/2019/09/9bf194dab700e70b57ca31b30982ee2c.jpg",
                    "Boaz Theofilius Erwin Solossa (born 16 March 1986) is an Indonesian professional footballer who currently plays for Liga 1 club Persipura Jayapura and the Indonesia national team. He is known for his high leveled dribbling technique, his shooting accuracy, and left-foot passing.",
                    "Indonesia"},
            {"Eden Hazard",
                    "7 January 1991 (age 28)",
                    "https://upload.wikimedia.org/wikipedia/commons/3/31/ENG-BEL_%2817%29.jpg",
                    "Eden Michael Hazard (French pronunciation: [edɛn azaʁ]; born 7 January 1991) is a Belgian professional footballer who plays as a winger or attacking midfielder for Spanish club Real Madrid and captains the Belgium national team. Widely considered as one of the best players in the world, Hazard is known for his creativity, speed, acceleration, dribbling and passing.",
                    "Belgia"},
            {"Demba Ba",
                    "25 May 1985 (age 34)",
                    "https://upload.wikimedia.org/wikipedia/commons/2/2a/Demba_Ba_BJK%2714.JPG",
                    "Demba Ba (born 25 May 1985) is a Senegalese professional footballer who plays as a striker for Turkish club İstanbul Başakşehir and the Senegal national team. He made his first-team debut with French team Rouen in 2005 before moving to Mouscron and onto 1899 Hoffenheim in Germany in 2007. In 2011, he moved to Premier League side West Ham United. He played only 12 games for West Ham and despite being their league top goal scorer in the 2010–11 season, they were relegated to the Championship and Ba moved to Newcastle United. In January 2013, he completed a move to Chelsea for an undisclosed fee, before joining Beşiktaş for €6 million 18 months later. After one season in Turkey, he moved to Shanghai Shenhua of the Chinese Super League.",
                    "Senegal"}
    };

    public static ArrayList<Player> getListData(){
        Player player;

        ArrayList<Player> list = new ArrayList<>();

        for (String[] mData : data){
            player = new Player();
            player.setName(mData[0]);
            player.setBorn(mData[1]);
            player.setPhoto(mData[2]);
            player.setDescription(mData[3]);
            player.setCountry(mData[4]);

            list.add(player);
        }

        return list;
    }
}

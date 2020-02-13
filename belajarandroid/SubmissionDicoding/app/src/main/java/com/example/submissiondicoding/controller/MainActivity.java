package com.example.submissiondicoding.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.submissiondicoding.R;
import com.example.submissiondicoding.adapter.PlayerAdapter;
import com.example.submissiondicoding.model.Player;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView playerListView;
    ImageView click;
    PlayerAdapter PlayerAdapter;
    private List<Player> listPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById();
        initData();
        dataGroup();

        onClick();

    }

     void findViewById() {

         playerListView= findViewById(R.id.listview);
         click=findViewById(R.id.line);
    }

    void initData() {
        listPlayer = new ArrayList();
        listPlayer.clear();
        PlayerAdapter = new PlayerAdapter(getApplicationContext(),listPlayer);
        playerListView.setAdapter(PlayerAdapter);
        PlayerAdapter.notifyDataSetChanged();
    }

    void dataGroup() {
        Player newUser = new Player();
        newUser.setNama("Bambang Pamungkas");
        newUser.setFoto(R.drawable.bepe);
        newUser.setNegara("Indonesian");
        newUser.setTanggallahir("10 Juni 1980");
        newUser.setDetail("Bambang Pamungkas (born 10 June 1980), also known as Bepe, is a retired Indonesian professional footballer who predominately played for Persija Jakarta and the Indonesia national football team. His natural position is striker. Bambang made his name in South East Asian football when he scored the only goal for Indonesia at the 2002 Tiger Cup semifinal against Malaysia,and was the tournament's top scorer with eight goals.");
        listPlayer.add(newUser);

        newUser = new Player();
        newUser.setNama("Ismed Sofyan");
        newUser.setFoto(R.drawable.ismedsofyan);
        newUser.setNegara("Indonesian");
        newUser.setTanggallahir("28 August 1979" );
        newUser.setDetail("Ismed Sofyan (born in Tualang Cut, Aceh 28 August 1979) is an Indonesian footballer who plays for Persija Jakarta in the Liga 1. He normally plays as a wing back or right back and his height is 169 cm. His speciality are free kick taking and assisting with high-curved pass. He has made 53 appearances for the Indonesia national football team.");
        listPlayer.add(newUser);

        newUser = new Player();
        newUser.setNama("Cristiano Ronaldo");
        newUser.setFoto(R.drawable.ronaldo);
        newUser.setNegara("Portugal");
        newUser.setTanggallahir("5 February 1985" );
        newUser.setDetail("Cristiano Ronaldo dos Santos Aveiro GOIH ComM (European Portuguese: [kɾiʃˈtjɐnu ʁɔˈnaɫdu]; born 5 February 1985) is a Portuguese professional footballer who plays as a forward for Serie A club Juventus and captains the Portugal national team. Often considered the best player in the world and widely regarded as one of the greatest players of all time, Ronaldo has won five Ballons d'Or and four European Golden Shoes, both of which are records for a European player. He has won 29 trophies in his career, including six league titles, five UEFA Champions Leagues, one UEFA European Championship, and one UEFA Nations League. A prolific goalscorer, Ronaldo holds the records for the most goals scored in the UEFA Champions League (128) and the joint-most goals scored in the UEFA European Championship . He has scored over 700 senior career goals for club and country.");
        listPlayer.add(newUser);

        newUser = new Player();
        newUser.setNama("Lionel Messi");
        newUser.setFoto(R.drawable.messi);
        newUser.setNegara("Argentine");
        newUser.setTanggallahir("24 June 1987" );
        newUser.setDetail("Lionel Andrés Messi Cuccittini (Spanish pronunciation: [ljoˈnel anˈdɾez ˈmesi] (About this soundlisten);[A] born 24 June 1987) is an Argentine professional footballer who plays as a forward and captains both Spanish club Barcelona and the Argentina national team. Often considered the best player in the world and widely regarded as one of the greatest players of all time, Messi has won a record six Ballon d'Or awards, and a record six European Golden Shoes. He has spent his entire professional career with Barcelona, where he has won a club-record 34 trophies, including ten La Liga titles, four UEFA Champions League titles and six Copas del Rey. A prolific goalscorer and a creative playmaker, Messi holds the records for most goals in La Liga (432), a La Liga and European league season (50), most hat-tricks in La Liga (35) and the UEFA Champions League, and most assists in La Liga (174) and the Copa América . He has scored over 700 senior career goals for club and country.");
        listPlayer.add(newUser);

        newUser = new Player();
        newUser.setNama("Frank Lampard");
        newUser.setFoto(R.drawable.lampard);
        newUser.setNegara("England");
        newUser.setTanggallahir("20 June 1978" );
        newUser.setDetail("Frank James Lampard OBE (born 20 June 1978) is an English professional football manager and former player who is the head coach of Premier League club Chelsea. As a player, he is widely considered to have been one of the greatest midfielders of his generation.[4]\n" +
                "\n" +
                "Lampard was a creative and technically gifted box-to-box midfielder who began his career in 1995 at West Ham United, the club where his father, Frank Lampard Sr., also played. He is best known for his time at London rivals Chelsea, after he signed for the club in 2001 for £11 million. In his thirteen years with the team, Lampard established himself as a prolific scorer from midfield, becoming Chelsea's all-time leading goalscorer, with 211 goals scored in all competitions. He also won a number of trophies, including three Premier League titles, a UEFA Champions League title, four FA Cups, a UEFA Europa League title, and two Football League Cups. In 2005, he was named FWA Footballer of the Year, and finished runner-up for both the Ballon d'Or and FIFA World Player of the Year awards. Lampard was released by Chelsea in 2014, after which he played for league rivals Manchester City and Major League Soccer (MLS) club New York City before retiring in 2017.");
        listPlayer.add(newUser);

        newUser = new Player();
        newUser.setNama("Ngolo Kante");
        newUser.setFoto(R.drawable.kante);
        newUser.setNegara("France");
        newUser.setTanggallahir("29 March 1991" );
        newUser.setDetail("N'Golo Kanté (French: [(ɛ)ŋɡolo kɑ̃te]; born 29 March 1991) is a French professional footballer who plays as a central midfielder for Premier League club Chelsea and the France national team. Although physically short in comparison to many modern midfielders, he is a dynamic and hard-working player, known for his energy and excellent ball-winning abilities as a box-to-box midfielder. Kanté is widely considered one of the most influential midfielders in the world.");
        listPlayer.add(newUser);

        newUser = new Player();
        newUser.setNama("Demba Ba");
        newUser.setFoto(R.drawable.ba);
        newUser.setNegara("France");
        newUser.setTanggallahir("25 May 1985 " );
        newUser.setDetail("Demba Ba (born 25 May 1985) is a Senegalese professional footballer who plays as a striker for Turkish club İstanbul Başakşehir and the Senegal national team.\n" +
                "\n" +
                "He made his first-team debut with French team Rouen in 2005 before moving to Mouscron and onto 1899 Hoffenheim in Germany in 2007. In 2011, he moved to Premier League side West Ham United. He played only 12 games for West Ham and despite being their league top goal scorer in the 2010–11 season, they were relegated to the Championship and Ba moved to Newcastle United. In January 2013, he completed a move to Chelsea for an undisclosed fee, before joining Beşiktaş for €6 million 18 months later. After one season in Turkey, he moved to Shanghai Shenhua of the Chinese Super League.");
        listPlayer.add(newUser);

        newUser = new Player();
        newUser.setNama("Son Heung-min");
        newUser.setFoto(R.drawable.son);
        newUser.setNegara("South Korea");
        newUser.setTanggallahir("8 July 1992" );
        newUser.setDetail("Son Heung-min (Korean: 손흥민; born 8 July 1992) is a South Korean professional footballer who plays as a winger for Premier League club Tottenham Hotspur and captains the South Korea national team. Considered as one of the best wingers in the world, Son is often cited as an icon of South Korean culture.\n" +
                "\n" +
                "Born in Chuncheon, Son joined Hamburger SV at the age of 16 and made his debut in the German Bundesliga in 2010. In 2013, he moved to Bayer Leverkusen for a club record €10 million before signing for English side Tottenham for £22 million two years later, becoming the most expensive Asian player in history. While at Tottenham, Son became the top Asian goalscorer in Premier League history and surpassed Cha Bum-kun's record for most goals scored by a Korean player in European competition.");
        listPlayer.add(newUser);

        newUser = new Player();
        newUser.setNama("Steven Gerrard");
        newUser.setFoto(R.drawable.gerarrd);
        newUser.setNegara("England");
        newUser.setTanggallahir("30 May 1980" );
        newUser.setDetail("Steven George Gerrard MBE (born 30 May 1980) is an English professional football manager and former player who manages Scottish Premiership club Rangers. He spent the majority of his playing career as a central midfielder for Liverpool, with most of that time spent as club captain, as well as captaining the England national team. Widely regarded as one of the greatest midfielders of all time, Gerrard was awarded the UEFA Club Footballer of the Year award in 2005, and the Ballon d'Or Bronze Award. In 2009, Zinedine Zidane and Pelé said that they considered Gerrard to be the best footballer in the world. A versatile and well-rounded player, highly regarded for his leadership, Gerrard is the only footballer to score in an FA Cup Final, a League Cup Final, a UEFA Cup Final and a UEFA Champions League Final, winning on each occasion.");
        listPlayer.add(newUser);

        newUser = new Player();
        newUser.setNama("Eden Hazard");
        newUser.setFoto(R.drawable.hazard);
        newUser.setNegara("Belgium");
        newUser.setTanggallahir("7 January 1991" );
        newUser.setDetail("Eden Michael Hazard (French pronunciation: \u200B[edɛn azaʁ]; born 7 January 1991) is a Belgian professional footballer who plays as a winger or attacking midfielder for Spanish club Real Madrid and captains the Belgium national team. Widely considered as one of the best players in the world, Hazard is known for his creativity, speed, acceleration, dribbling and passing.\n" +
                "\n" +
                "Hazard is the son of two former footballers and began his career in Belgium playing for local youth clubs. In 2005, he moved to France, where he began his senior career with Ligue 1 club Lille. Hazard spent two years in the club's academy and, at the age of 16, made his professional debut in November 2007. He went on to become an integral part of the Lille team under manager Rudi Garcia, making over 190 appearances. In his first full season as a starter, he won the Ligue 1 Young Player of the Year award, becoming the first non-French player to win the award. In the 2009–10 season, Hazard captured the award again, becoming the first player to win the award twice. He was also named to the Ligue 1 Team of the Year. In the 2010–11 season, he was a part of the Lille team that won the league and cup double and, as a result of his performances, was named the Ligue 1 Player of the Year, the youngest player to win the award. Hazard was also given the Bravo Award by Italian magazine Guerin Sportivo for his performances during this season.");
        listPlayer.add(newUser);




        PlayerAdapter.notifyDataSetChanged();
    }

    void onClick() {
        playerListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(MainActivity.this,DetailActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("nama", listPlayer.get(position).getNama());
                bundle.putInt("foto",listPlayer.get(position).getFoto());
                bundle.putString("negara",listPlayer.get(position).getNegara());
                bundle.putString("tanggallahir",listPlayer.get(position).getTanggallahir());
                bundle.putString("detail",listPlayer.get(position).getDetail());
                intent.putExtras(bundle);
                startActivity(intent);


            }
        });

        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AboutActivity.class);
                startActivity(intent);

            }
        });
    }
}

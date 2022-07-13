package com.gultendogan.narutorecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.gultendogan.narutorecyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var narutoList: ArrayList<Naruto>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        //initialize
        narutoList = ArrayList()


        //Data
        val gaara = Naruto(
            "Gaara",
            "Gaara (我愛羅, Gaara) is a shinobi of Sunagakure. " +
                "He was made the jinchūriki of the One-Tailed Shukaku before he was born, causing " +
                "the villagers of Suna to fear him as a monster",
                R.drawable.gaara)

        val hinata = Naruto(
            "Hinata",
            "Hinata Uzumaki (うずまきヒナタ, Uzumaki Hinata, née Hyūga (日向)) is a kunoichi of Konohagakure. " +
                    "Formerly the heiress of the Hyūga clan, she lost the position upon being deemed unsuited for " +
                    "the responsibilities of leading the clan.",
            R.drawable.hinata)

        val itachi = Naruto(
            "Itachi",
            "Itachi Uchiha (うちはイタチ, Uchiha Itachi) was a shinobi of Konohagakure's Uchiha clan who served as " +
                    "an Anbu Captain. He later became an international criminal after murdering his entire clan, sparing " +
                    "only his younger brother, Sasuke.",
            R.drawable.itachi)

        val jiraiya = Naruto(
            "Jiraiya",
            "Jiraiya (自来也) was one of Konohagakure's Sannin. Famed as a hermit and pervert of stupendous ninja skill, " +
                    "Jiraiya travelled the world in search of knowledge that would help his friends, the various novels he wrote, " +
                    "and, posthumously, the world in its entirety – knowledge that would be passed on to his godson and final student, " +
                    "Naruto Uzumaki.",
            R.drawable.jiraiya)

        val kakashi = Naruto(
            "Kakashi",
            "Kakashi Hatake (はたけカカシ, Hatake Kakashi) is a shinobi of Konohagakure's Hatake clan. Famed as Kakashi of the Sharingan " +
                    "(写輪眼のカカシ, Sharingan no Kakashi), he is one of Konoha's most talented ninja, regularly looked to for advice and " +
                    "leadership despite his personal dislike of responsibility. ",
            R.drawable.kakashi)

        val kankuro = Naruto(
            "Kanjuro",
            "Kankurō (カンクロウ, Kankurō) is a shinobi of Sunagakure and the second eldest of the Three Sand Siblings.",
            R.drawable.kankuro)

        val minato = Naruto(
            "Minato",
            "Minato Namikaze (波風ミナト, Namikaze Minato) was the Fourth Hokage (四代目火影, Yondaime Hokage, " +
                    "literally meaning: Fourth Fire Shadow) of Konohagakure.",
            R.drawable.minatonamikaze)

        val nagato = Naruto(
            "Nagato",
            "Nagato (長門, Nagato) was a shinobi of Amegakure and descendant of the Uzumaki clan. Forming Akatsuki " +
                    "alongside his friends (and fellow war orphans) Yahiko and Konan, Nagato dreamed of bringing peace to " +
                    "the violent shinobi world.",
            R.drawable.nagato)

        val naruto = Naruto(
            "Naruto",
            "Naruto Uzumaki (うずまきナルト, Uzumaki Naruto) is a shinobi of Konohagakure's Uzumaki clan. He became the " +
                    "jinchūriki of the Nine-Tails on the day of his birth — a fate that caused him to be shunned by most of Konoha " +
                    "throughout his childhood. ",
            R.drawable.narutouzumaki)

        val orochimaru = Naruto(
            "Orochimaru",
            "Orochimaru (大蛇丸, Orochimaru) is one of Konohagakure's legendary Sannin. With a life-ambition to learn all of " +
                    "the world's secrets, Orochimaru seeks immortality so that he might live all of the lives necessary to accomplish his task.",
            R.drawable.orochimaru)

        val rocklee = Naruto(
            "Rock Lee",
            "Rock Lee (ロック・リー, Rokku Rī) is a shinobi of Konohagakure's Lee clan and a member of Team Guy. Unlike most shinobi, " +
                    "he lacked the skills necessary to use ninjutsu or genjutsu.",
            R.drawable.rock_lee)

        val sai = Naruto(
            "Sai",
            "Sai Yamanaka (山中サイ, Yamanaka Sai) is the Anbu Chief of Konohagakure's Yamanaka clan. Prior to this, he was a Root member. " +
                    "As per standard Root training.",
            R.drawable.sai)

        val sakura = Naruto(
            "Sakura",
            "Sakura Uchiha (うちはサクラ, Uchiha Sakura, née Haruno (春野)) is a kunoichi of Konohagakure. When assigned to Team 7, " +
                    "Sakura quickly finds herself ill-prepared for the duties of a shinobi.",
            R.drawable.sakura)

        val sasori = Naruto(
            "Sasori",
            "Sasori (サソリ, Sasori), renowned as Sasori of the Red Sand (赤砂のサソリ, Akasuna no Sasori), was an S-rank missing-nin " +
                    "from Sunagakure's Puppet Brigade and a member of Akatsuki, where he was partnered with Orochimaru and later Deidara.",
            R.drawable.sasori)

        val sasuke = Naruto(
            "Sasuke",
            "Sasuke Uchiha (うちはサスケ, Uchiha Sasuke) is one of the last surviving members of Konohagakure's Uchiha clan. After his older " +
                    "brother, Itachi, slaughtered their clan, Sasuke made it his mission in life to avenge them by killing Itachi. ",
            R.drawable.sasukeuchiha)

        val shikamaru = Naruto(
            "Shikamaru",
            "Shikamaru Nara (奈良シカマル, Nara Shikamaru) is a shinobi of Konohagakure's Nara clan. Though lazy by nature, Shikamaru has a rare " +
                    "intellect that consistently allows him to prevail in combat.",
            R.drawable.shikamaru)

        val tsunade = Naruto(
            "Tsunade",
            "Tsunade (綱手, Tsunade) is a descendant of the Senju and Uzumaki Clan, and is one of Konohagakure's Sannin. She is famed as the " +
                    "world's strongest kunoichi and its greatest medical-nin.",
            R.drawable.tsunade)



        narutoList.add(gaara)
        narutoList.add(hinata)
        narutoList.add(itachi)
        narutoList.add(jiraiya)
        narutoList.add(kakashi)
        narutoList.add(kankuro)
        narutoList.add(minato)
        narutoList.add(nagato)
        narutoList.add(naruto)
        narutoList.add(orochimaru)
        narutoList.add(rocklee)
        narutoList.add(sai)
        narutoList.add(sakura)
        narutoList.add(sasori)
        narutoList.add(sasuke)
        narutoList.add(shikamaru)
        narutoList.add(tsunade)

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        val narutoAdapter = NarutoAdapter(narutoList)
        binding.recyclerView.adapter = narutoAdapter
    }
}
package pio.dellon.cabroli.utils

object QuestionsAndAnswers {

    fun getQuestion(): ArrayList<Question> {

        val questionsList = ArrayList<Question>()

        val que1 = Question(
            1,
            "Jak opisałbyś swoje obecne podejście do finansów?",
            "a) Sztywne i ograniczające",
            "b) Zorientowane na rozwój i otwarte na możliwości",
            "c) Obojętne lub niepewne",
            2
        )

        val que2 = Question(
            2,
            "Jak zazwyczaj podchodzisz do wyzwań finansowych?",
            "a) Strategiczne planowanie i rozwiązywanie problemów",
            "b) Unikanie i odkładanie na później",
            "c) Szukanie porad i wsparcia",
            1
        )

        val que3 = Question(
            3,
            "Które zdanie najlepiej odzwierciedla twoje przekonania dotyczące tworzenia bogactwa?",
            "a) Bogactwo można osiągnąć poprzez ciężką pracę i mądre decyzje",
            "b) Bogactwo nie jest priorytetem w moim życiu",
            "c) Bogactwo jest zarezerwowane tylko dla nielicznych szczęśliwców",
            1
        )

        val que4 = Question(
            4,
            "Jak radzisz sobie z finansowymi niepowodzeniami?",
            "a) Łatwo się poddajesz i czujesz się pokonany",
            "b) Obwiniasz zewnętrzne okoliczności lub innych ludzi",
            "c) Uczysz się na błędach i szukasz alternatywnych rozwiązań",
            3
        )

        val que5 = Question(
            5,
            "Jaki jest twój stosunek do edukacji finansowej i samodoskonalenia?",
            "a) Poleganie wyłącznie na doradcach finansowych przy podejmowaniu decyzji",
            "b) Ciągłe poszukiwanie okazji do nauki i rozwoju",
            "c) Brak zainteresowania poszerzaniem wiedzy finansowej",
            2
        )

        val que6 = Question(
            6,
            "Jak definiujesz sukces finansowy?",
            "a) Posiadanie luksusowych przedmiotów i rzeczy",
            "b) Niezainteresowanie się sukcesem finansowym",
            "c) Osiągnięcie stabilności finansowej i wolności",
            3
        )

        val que7 = Question(
            7,
            "Jak wygodne czujesz się podejmując obliczone ryzyko w swoich przedsięwzięciach finansowych?",
            "a) Skłonny podejmować umiarkowane ryzyko po odpowiedniej ocenie",
            "b) Wyjątkowo obawiający się ryzyka, unikanie jakiejkolwiek formy ryzyka",
            "c) Wygodny z podejmowaniem wysokiego ryzyka bez dużego namysłu",
            1
        )

        val que8 = Question(
            8,
            "Jak zarządzasz swoimi celami finansowymi i śledzisz postępy?",
            "a) Poleganie na szczęściu lub przypadku w finansowych rezultatach\n",
            "b) Ustalanie jasnych celów i regularne monitorowanie postępów",
            "c) Brak konkretnych celów lub systemu śledzenia postępów",
            2
        )

        val que9 = Question(
            9,
            "Jak radzisz sobie z pokusami finansowymi lub impulsywnym wydawaniem?",
            "a) Całkowicie ignorujesz pokusy finansowe",
            "b) Łatwo ulegasz pokusom, masz trudności z samokontrolą",
            "c) Praktykujesz dyscyplinę i priorytetyzujesz długoterminowe cele finansowe",
            3
        )

        val que10 = Question(
            10,
            "Jak postrzegasz finansowe niepowodzenia lub porażki?",
            "a) Jako trwałe i nie do pokonania przeszkody",
            "b) Jako tymczasowe niepowodzenia, które można pokonać",
            "c) Jako oznaki osobistej niekompetencji lub braku wartości",
            2
        )

        questionsList.add(que1)
        questionsList.add(que2)
        questionsList.add(que3)
        questionsList.add(que4)
        questionsList.add(que5)
        questionsList.add(que6)
        questionsList.add(que7)
        questionsList.add(que8)
        questionsList.add(que9)
        questionsList.add(que10)

        return questionsList
    }
}
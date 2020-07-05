package com.sport.rental.service;

import java.util.Collections;

import javax.annotation.PostConstruct;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sport.rental.model.Category;
import com.sport.rental.model.Comment;
import com.sport.rental.model.Item;
import com.sport.rental.model.Storage;
import com.sport.rental.model.User;
import com.sport.rental.repository.CategoryRepository;
import com.sport.rental.repository.CommentRepository;
import com.sport.rental.repository.ItemRepository;
import com.sport.rental.repository.ReservationRepository;
import com.sport.rental.repository.StorageRepository;
import com.sport.rental.repository.UserRepository;

@Service
public class InitDataLoader {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ItemRepository itemRepository;

	@Autowired
	private ReservationRepository reservationRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private CommentRepository commentRepository;

	@Autowired
	private StorageRepository storageRepository;

	@PostConstruct
	public void init() {
		User user1 = new User(null, "Adam", "Adamski", "admin@admin.pl", DigestUtils
				.md5Hex("admin").toUpperCase(), 1, Collections.emptyList(),
				Collections.emptyList());
		User user2 = new User(null, "Grzegorz", "Worlek", "test@test.pl", DigestUtils
				.md5Hex("test").toUpperCase(), 2, Collections.emptyList(),
				Collections.emptyList());
		User user3 = new User(null, "Mateusz", "Cichy", "test2@test.pl", DigestUtils
				.md5Hex("test").toUpperCase(), 2, Collections.emptyList(),
				Collections.emptyList());

		userRepository.save(user1);
		userRepository.save(user2);
		userRepository.save(user3);

		Storage storage1 = new Storage(null, "Magazyn Główny", "Warszawa, Aleja Wojska Polskiego 33",
				Collections.emptyList());
		Storage storage2 = new Storage(null, "Magazyn Wysyłkowy", "Kraków, Nowa 33", Collections.emptyList());
		Storage storage3 = new Storage(null, "Magazyn Zapasowy", "Gdańsk, Stara 10", Collections.emptyList());

		storageRepository.save(storage1);
		storageRepository.save(storage2);
		storageRepository.save(storage3);

		Category category1 = new Category(null, "Rowery",
				"https://www.fitnesswdomu.pl/wp-content/uploads/2017/12/Rower-treningowy-inSPORTline-inCondi-UB600i.jpg",
				Collections.emptyList());
		Category category2 = new Category(null, "Bieżnie",
				"https://www.fitnesswdomu.pl/wp-content/uploads/2017/07/runner_axer1.jpg", Collections.emptyList());
		Category category3 = new Category(null, "Wiosła",
				"https://www.fitnesswdomu.pl/wp-content/uploads/2020/01/Concept2-Model-E-1-a-sm.jpg",
				Collections.emptyList());
		Category category4 = new Category(null, "Orbitreki",
				"https://www.fitnesswdomu.pl/wp-content/uploads/2017/07/e850p.jpg",
				Collections.emptyList());

		categoryRepository.save(category1);
		categoryRepository.save(category2);
		categoryRepository.save(category3);
		categoryRepository.save(category4);


		Item item1 = new Item(null, "Pionowy Typ A",
				"Airbike SPIRIT AB900 to nowa jakość w tego typu konstrukcjach.\n"
						+ "\n"
						+ "Maszyna jest bardzo solidnie wykonana. Waży troszkę więcej od standardowych maszyn w swojej klasie, ale dzięki temu zapewnia niespotykany wcześniej komfort treningu.",
				50,
				"https://www.fitnesswdomu.pl/wp-content/uploads/2017/12/Rower-treningowy-inSPORTline-inCondi-UB600i.jpg",
				true,
				category1, storage1, Collections.emptyList(), Collections.emptyList());

		Item item2 = new Item(null, "Pionowy Typ B",
				"B 800 to idealne rozwiązanie  do użytku domowego jak i rehabilitacji. Posiada opór magnetyczny sterowany komputerowo oraz wagę koła aż 8 kg oraz 12 profili umożliwiających samodzielne prowadzenie idealnego treningu bez wychodzenia z domu. A 8-funkcyjny licznik wskazuje czas ćwiczenia, prędkość, z jaką wykonujemy ćwiczenie, dystans, jaki przejechaliśmy oraz całkowity, a także szacunkową wartość spalonych prze nas kalorii w trakcie ćwiczenia i dzięki funkcji Hand Puls – nasz puls w uderzeniach na minutę, jak również obroty na minutę.",
				100,
				"https://www.fitnesswdomu.pl/wp-content/uploads/2019/11/spirit_ab900_air_bike-2.jpg",
				true,
				category1, storage2, Collections.emptyList(), Collections.emptyList());

		Item item3 = new Item(null, "Pionowy Typ C",
				"Airbike to nietypowa maszyna która łączy w sobie najlepsze elementy innych maszyn fitness. Urządzenia które Airbike łączy w sobie to rower stacjonarny, wioślarza i orbitrek. Można śmiało powiedzieć że jest to hybrydowa maszyna fitness.",
				150,
				"https://www.fitnesswdomu.pl/wp-content/uploads/2019/07/SPIRIT-xbu55-2.png",
				true,
				category1, storage3, Collections.emptyList(), Collections.emptyList());

		Item item4 = new Item(null, "Pionowy Typ D",
				"Kompaktowy, składany rower stacjonarny Xterra FB 150 to dobry wstęp do treningów domowych, dla osób odchudzających się, przechodzących rehabilitację i podnoszących sprawność fizyczną w domu. Cechuje go stabilna konstrukcja, dobrej jakości wykonanie oraz płynna i chicha praca. Trening na nim jest wygodny i cichy a jego wyniki można sprawdzać na elektronicznym wyświetlaczu pokazującym podstawowe parametry treningowe. Po zakończonym treningu rower można jednym ruchem złożyć i przewieźć używając kółek transportowych.\n"
						+ "\n"
						+ "Kompaktowa konstrukcja pozwala na schowanie roweru FB150 np. do szafy. Dzięki czemu możemy spokojnie po treningu uwolnić przestrzeń do codziennych aktywności.\n"
						+ "\n"
						+ "Instrukcja obsługi tylko w języku angielskim.",
				200,
				"https://www.fitnesswdomu.pl/wp-content/uploads/2017/07/ROWER-SK%C5%81ADANY-XTERRA-FB150.jpg",
				true,
				category1, storage1, Collections.emptyList(), Collections.emptyList());

		itemRepository.save(item1);
		itemRepository.save(item2);
		itemRepository.save(item3);
		itemRepository.save(item4);

		Item item5 = new Item(null, "Bieznia Typ A",
				"Bieżnia Axer Runner to solidny sprzęt dla wymagających użytkowników. Klasa urządzenia HA (dla normy EN957) napędzana silnikiem elektrycznym o mocy 3 HP",
				350,
				"https://www.fitnesswdomu.pl/wp-content/uploads/2017/07/runner_axer1.jpg",
				true,
				category2, storage1, Collections.emptyList(), Collections.emptyList());

		Item item6 = new Item(null, "Bieznia Typ B",
				"Wysokiej klasy bieżnia treningowa Marki UNO Fitness, model TR 500.\n"
						+ "\n"
						+ "Maszyna charakteryzuje się dużą ergonomią dzięki dodatkowym uchwytom wystającym z ramy. Pozwalają one regulować szybkość biegu jak i kąt nachylenia rampy. To wszystko bez konieczności sięgania głównej konsoli.",
				300,
				"https://www.fitnesswdomu.pl/wp-content/uploads/2017/07/tr500-BIE%C5%BBNIA-500x500.png",
				true,
				category2, storage1, Collections.emptyList(), Collections.emptyList());

		itemRepository.save(item5);
		itemRepository.save(item6);

		Item item7 = new Item(null, "Wiosło Typ A",
				"Wiosła Model E zostały specjalnie zaprojektowane dla wygody użytkownika. Rama ergometru wioślarskiego została wykonana z wysokiej, jakości stali, ale nie to stanowi o wygodzie wioślarza, jego zaletą jest wysokość ramy (51 cm), która zapewnia komfortowy dostęp do sprzętu (wygoda wsiadania i zsiadania). Dla osób, które mają problemy z kolanami lub kręgosłupem będzie to ważna cecha sprzętu.",
				400,
				"https://www.fitnesswdomu.pl/wp-content/uploads/2020/01/Concept2-Model-E-1-a-sm.jpg",
				true,
				category3, storage3, Collections.emptyList(), Collections.emptyList());

		Item item8 = new Item(null, "Orbitrek Typ A",
				"Axer VIPER to przyjemna maszyna w obsłudze dzięki ergonomicznej konstrukcji.\n"
						+ "\n"
						+ "Niewielkie rozmiary w stosunku do orbitreków przednio napędowych czynią go idealnym rozwiązaniem dla osób posiadających ograniczoną przestrzeń.",
				500,
				"https://www.fitnesswdomu.pl/wp-content/uploads/2017/07/e850p.jpg",
				true,
				category4, storage3, Collections.emptyList(), Collections.emptyList());

		itemRepository.save(item7);
		itemRepository.save(item8);

		Comment comment1 = new Comment(null, "Bardzo dobry sprzet", item1, user2);
		Comment comment2 = new Comment(null, "Bardzo dobry sprzet polecam rowniez", item1, user3);
		Comment comment3 = new Comment(null, "Tanio i dobrze", item2, user2);
		Comment comment4 = new Comment(null, "Bardzo dobry sprzet", item3, user3);
		Comment comment5 = new Comment(null, "Dal mi mocno w kosc", item4, user2);
		Comment comment6 = new Comment(null, "Bardzo dobry sprzet", item5, user3);
		Comment comment7 = new Comment(null, "Bardzo dobry sprzet", item6, user2);
		Comment comment8 = new Comment(null, "Polecam", item7, user2);
		Comment comment9 = new Comment(null, "Super", item7, user3);

		commentRepository.save(comment1);
		commentRepository.save(comment2);
		commentRepository.save(comment3);
		commentRepository.save(comment4);
		commentRepository.save(comment5);
		commentRepository.save(comment6);
		commentRepository.save(comment7);
		commentRepository.save(comment8);
		commentRepository.save(comment9);
	}
}
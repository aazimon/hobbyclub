# create clubs with owners.
INSERT INTO clubs (name, description, category_id, city_id, state_id, creator_id, active)
SELECT 'Otaku Society', 'A community for anime lovers to meet, watch series, and dive deep into Japanese animation culture together.', 1, c.city_id, c.state_id, a.account_id, 'A' FROM accounts a JOIN city c ON a.city_id = c.city_id WHERE a.nick_name = 'ThorChris';
INSERT INTO clubs (name, description, category_id, city_id, state_id, creator_id, active)
SELECT 'Anime Sketch Circle', 'For those who love to draw anime characters and share fan art, styles, and techniques.', 1,c.city_id, c.state_id, a.account_id, 'A' FROM accounts a JOIN city c ON a.city_id = c.city_id WHERE a.nick_name = 'WandaLiz';
INSERT INTO clubs (name, description, category_id, city_id, state_id, creator_id, active)
SELECT 'Shonen Showdown', 'Focused on high-energy anime like Naruto and My Hero Academia, this club hosts weekly watch nights and trivia battles.', 1,c.city_id, c.state_id, a.account_id, 'A' FROM accounts a JOIN city c ON a.city_id = c.city_id WHERE a.nick_name = 'EGreen';
INSERT INTO clubs (name, description, category_id, city_id, state_id, creator_id, active)
SELECT 'Cosplay Collective', 'Bringing together fans of cosplay to craft, build, and showcase their favorite anime-inspired outfits.', 1, c.city_id, c.state_id, a.account_id, 'A' FROM accounts a JOIN city c ON a.city_id = c.city_id WHERE a.nick_name = 'ASharma';
INSERT INTO clubs (name, description, category_id, city_id, state_id, creator_id, active)
SELECT 'Studio Ghibli Nights', 'Dedicated to the magical world of Studio Ghibli films — join for film screenings and discussion forums.', 1,c.city_id, c.state_id, a.account_id, 'A' FROM accounts a JOIN city c ON a.city_id = c.city_id WHERE a.nick_name = 'HRoshan';
INSERT INTO clubs (name, description, category_id, city_id, state_id, creator_id, active)
SELECT 'The Creative Palette', 'A space for all kinds of artists to create, share, and critique various mediums like painting, sketching, and sculpture.', 2,c.city_id, c.state_id, a.account_id, 'A' FROM accounts a JOIN city c ON a.city_id = c.city_id WHERE a.nick_name = 'EmStoner';
INSERT INTO clubs (name, description, category_id, city_id, state_id, creator_id, active)
SELECT 'Sketch & Sip Society', 'An informal group that hosts laid-back sketch sessions often paired with coffee or tea.', 2,c.city_id, c.state_id, a.account_id, 'A' FROM accounts a JOIN city c ON a.city_id = c.city_id WHERE a.nick_name = 'SpideyTom';
INSERT INTO clubs (name, description, category_id, city_id, state_id, creator_id, active)
SELECT 'Digital Art Collective', 'Focused on digital art techniques including Photoshop, Illustrator, and Procreate, with workshops and critiques.', 2,c.city_id, c.state_id, a.account_id, 'A' FROM accounts a JOIN city c ON a.city_id = c.city_id WHERE a.nick_name = 'FloP';
INSERT INTO clubs (name, description, category_id, city_id, state_id, creator_id, active)
SELECT 'Street Art Underground', 'Explore the urban landscape through graffiti and mural projects with fellow street artists.', 2,c.city_id, c.state_id, a.account_id, 'A' FROM accounts a JOIN city c ON a.city_id = c.city_id WHERE a.nick_name = 'JOrtega';
INSERT INTO clubs (name, description, category_id, city_id, state_id, creator_id, active)
SELECT 'Watercolor Wonders', 'Specialized in watercolor painting techniques, this club organizes step-by-step sessions and art swaps.', 2,c.city_id, c.state_id, a.account_id, 'A' FROM accounts a JOIN city c ON a.city_id = c.city_id WHERE a.nick_name = 'JBardem';
INSERT INTO clubs (name, description, category_id, city_id, state_id, creator_id, active)
SELECT 'Stargazers United', 'Come explore the cosmos with telescope meetups, meteor shower parties, and discussions on celestial events.', 3,c.city_id, c.state_id, a.account_id, 'A' FROM accounts a JOIN city c ON a.city_id = c.city_id WHERE a.nick_name = 'TitanKate';
INSERT INTO clubs (name, description, category_id, city_id, state_id, creator_id, active)
SELECT 'Planet Hunters', 'Track and study planets and exoplanets using open-source data and hands-on sessions with amateur astronomy tools.', 3,c.city_id, c.state_id, a.account_id, 'A' FROM accounts a JOIN city c ON a.city_id = c.city_id WHERE a.nick_name = 'WonderGal';
INSERT INTO clubs (name, description, category_id, city_id, state_id, creator_id, active)
SELECT 'Astrophotography Club', 'Dedicated to capturing the beauty of the night sky — from star trails to deep space photos.', 3,c.city_id, c.state_id, a.account_id, 'A' FROM accounts a JOIN city c ON a.city_id = c.city_id WHERE a.nick_name = 'LetoJ';
INSERT INTO clubs (name, description, category_id, city_id, state_id, creator_id, active)
SELECT 'Lunar Legends', 'A club devoted to moon lore, lunar events, and regular moon-gazing sessions.', 3,c.city_id, c.state_id, a.account_id, 'A' FROM accounts a JOIN city c ON a.city_id = c.city_id WHERE a.nick_name = 'MadsM';
INSERT INTO clubs (name, description, category_id, city_id, state_id, creator_id, active)
SELECT 'Cosmic Curiosity', 'This group explores the universe through documentaries, simulations, and astronomy lectures from experts.', 3,c.city_id, c.state_id, a.account_id, 'A' FROM accounts a JOIN city c ON a.city_id = c.city_id WHERE a.nick_name = 'VDhawan';
INSERT INTO clubs (name, description, category_id, city_id, state_id, creator_id, active)
SELECT 'Meeples & Dice', 'Join us for regular board game nights featuring classics and new indie releases.', 4,c.city_id, c.state_id, a.account_id, 'A' FROM accounts a JOIN city c ON a.city_id = c.city_id WHERE a.nick_name = 'EmStoner';
INSERT INTO clubs (name, description, category_id, city_id, state_id, creator_id, active)
SELECT 'Tabletop Titans', 'Competitive and cooperative strategy game enthusiasts gather to play everything from Risk to Twilight Imperium.', 4,c.city_id, c.state_id, a.account_id, 'A' FROM accounts a JOIN city c ON a.city_id = c.city_id WHERE a.nick_name = 'SpideyTom';
INSERT INTO clubs (name, description, category_id, city_id, state_id, creator_id, active)
SELECT 'Casual Cardboard', 'Low-stakes, high-fun game nights designed for quick and easy play, suitable for all ages.', 4,c.city_id, c.state_id, a.account_id, 'A' FROM accounts a JOIN city c ON a.city_id = c.city_id WHERE a.nick_name = 'MavCruise';
INSERT INTO clubs (name, description, category_id, city_id, state_id, creator_id, active)
SELECT 'Board Game Designers Guild', 'Aspiring board game creators collaborate to test, critique, and develop their own games.', 4,c.city_id, c.state_id, a.account_id, 'A' FROM accounts a JOIN city c ON a.city_id = c.city_id WHERE a.nick_name = 'BourneMatt';
INSERT INTO clubs (name, description, category_id, city_id, state_id, creator_id, active)
SELECT 'Legacy League', 'Dive deep into legacy board games with a group that plays through entire campaigns over time.', 4,c.city_id, c.state_id, a.account_id, 'A' FROM accounts a JOIN city c ON a.city_id = c.city_id WHERE a.nick_name = 'AquaJay';
INSERT INTO clubs (name, description, category_id, city_id, state_id, creator_id, active)
SELECT 'Page Turners', 'A diverse reading group that explores fiction and non-fiction from global authors and varied genres.', 5,c.city_id, c.state_id, a.account_id, 'A' FROM accounts a JOIN city c ON a.city_id = c.city_id WHERE a.nick_name = 'PCruz';
INSERT INTO clubs (name, description, category_id, city_id, state_id, creator_id, active)
SELECT 'Mystery Book Circle', 'Perfect for fans of whodunits and thrillers — meet to discuss twists, suspects, and plot reveals.', 5,c.city_id, c.state_id, a.account_id, 'A' FROM accounts a JOIN city c ON a.city_id = c.city_id WHERE a.nick_name = 'ZQueen';
INSERT INTO clubs (name, description, category_id, city_id, state_id, creator_id, active)
SELECT 'Historical Fiction Guild', 'Dive into the past through literature with monthly reads that focus on different eras and cultures.', 5,c.city_id, c.state_id, a.account_id, 'A' FROM accounts a JOIN city c ON a.city_id = c.city_id WHERE a.nick_name = 'Tabz';
INSERT INTO clubs (name, description, category_id, city_id, state_id, creator_id, active)
SELECT 'Fantasy Realms Reading Club', 'From Tolkien to Sanderson, this group explores epic worlds and fantastical adventures.', 5,c.city_id, c.state_id, a.account_id, 'A' FROM accounts a JOIN city c ON a.city_id = c.city_id WHERE a.nick_name = 'ScarJo';
INSERT INTO clubs (name, description, category_id, city_id, state_id, creator_id, active)
SELECT 'Silent Reading Social', 'A club for introverts and bookworms — read together in silence, then stay for casual discussions.', 5,c.city_id, c.state_id, a.account_id, 'A' FROM accounts a JOIN city c ON a.city_id = c.city_id WHERE a.nick_name = 'TitanKate';
INSERT INTO clubs (name, description, category_id, city_id, state_id, creator_id, active)
SELECT 'The Pit Stop', 'A community of car lovers who meet to share knowledge about automotive repair, modifications, and racing.', 6,c.city_id, c.state_id, a.account_id, 'A' FROM accounts a JOIN city c ON a.city_id = c.city_id WHERE a.nick_name = 'ScarJo';
INSERT INTO clubs (name, description, category_id, city_id, state_id, creator_id, active)
SELECT 'Vintage Vibes', 'Focused on classic cars, this group meets for restoration tips, vintage car exhibitions, and history discussions.', 6,c.city_id, c.state_id, a.account_id, 'A' FROM accounts a JOIN city c ON a.city_id = c.city_id WHERE a.nick_name = 'TitanKate';
INSERT INTO clubs (name, description, category_id, city_id, state_id, creator_id, active)
SELECT 'Electric Drive', 'A club dedicated to electric vehicles, with discussions on technology, sustainability, and the future of green driving.', 6,c.city_id, c.state_id, a.account_id, 'A' FROM accounts a JOIN city c ON a.city_id = c.city_id WHERE a.nick_name = 'ACurtis';
INSERT INTO clubs (name, description, category_id, city_id, state_id, creator_id, active)
SELECT 'Motor Head Racing', 'Racing enthusiasts come together to talk about performance cars, racing events, and modifications to improve speed and handling.', 6,c.city_id, c.state_id, a.account_id, 'A' FROM accounts a JOIN city c ON a.city_id = c.city_id WHERE a.nick_name = 'AquaJay';
INSERT INTO clubs (name, description, category_id, city_id, state_id, creator_id, active)
SELECT 'Car Photography Collective', 'Capturing the beauty of automobiles through lenses — from luxury cars to modified rides, join for photo shoots and contests.', 6,c.city_id, c.state_id, a.account_id, 'A' FROM accounts a JOIN city c ON a.city_id = c.city_id WHERE a.nick_name = 'PascalP';
INSERT INTO clubs (name, description, category_id, city_id, state_id, creator_id, active)
SELECT 'Checkmate Collective', 'A group for chess enthusiasts of all levels, where players come together for casual games and tournaments.', 7,c.city_id, c.state_id, a.account_id, 'A' FROM accounts a JOIN city c ON a.city_id = c.city_id WHERE a.nick_name = 'IronBob';
INSERT INTO clubs (name, description, category_id, city_id, state_id, creator_id, active)
SELECT 'The Rook and Pawn', 'Focused on strategy and tactics, this club regularly organizes chess puzzles, problem-solving, and competition events.', 7,c.city_id, c.state_id, a.account_id, 'A' FROM accounts a JOIN city c ON a.city_id = c.city_id WHERE a.nick_name = 'JLaw';
INSERT INTO clubs (name, description, category_id, city_id, state_id, creator_id, active)
SELECT 'Speed Chess Society', 'Love fast-paced games? Join us for blitz chess tournaments and rapid play to sharpen your skills.', 7,c.city_id, c.state_id, a.account_id, 'A' FROM accounts a JOIN city c ON a.city_id = c.city_id WHERE a.nick_name = 'ZQueen';
INSERT INTO clubs (name, description, category_id, city_id, state_id, creator_id, active)
SELECT 'Chess for Beginners', 'New to the game? This club is perfect for beginners looking to improve their knowledge and skills, with lessons and advice from experienced players.', 7,c.city_id, c.state_id, a.account_id, 'A' FROM accounts a JOIN city c ON a.city_id = c.city_id WHERE a.nick_name = 'Zefron';
INSERT INTO clubs (name, description, category_id, city_id, state_id, creator_id, active)
SELECT 'Grandmasters Circle', 'A club for advanced players who want to discuss openings, endgames, and grandmaster-level strategies.', 7,c.city_id, c.state_id, a.account_id, 'A' FROM accounts a JOIN city c ON a.city_id = c.city_id WHERE a.nick_name = 'FloP';
INSERT INTO clubs (name, description, category_id, city_id, state_id, creator_id, active)
SELECT 'Gastronomy Gurus', 'A club for food enthusiasts who enjoy cooking together and exploring new recipes from different cuisines.', 8,c.city_id, c.state_id, a.account_id, 'A' FROM accounts a JOIN city c ON a.city_id = c.city_id WHERE a.nick_name = 'NSchnapp';
INSERT INTO clubs (name, description, category_id, city_id, state_id, creator_id, active)
SELECT 'Baking Brigade', 'From cakes to cookies, this club brings bakers together to perfect their skills and share their passion for pastries.', 8,c.city_id, c.state_id, a.account_id, 'A' FROM accounts a JOIN city c ON a.city_id = c.city_id WHERE a.nick_name = 'IKhan';
INSERT INTO clubs (name, description, category_id, city_id, state_id, creator_id, active)
SELECT 'Farm-to-Table', 'Focus on fresh, local ingredients and sustainable cooking practices, with an emphasis on organic and seasonal recipes.', 8,c.city_id, c.state_id, a.account_id, 'A' FROM accounts a JOIN city c ON a.city_id = c.city_id WHERE a.nick_name = 'KKaif';
INSERT INTO clubs (name, description, category_id, city_id, state_id, creator_id, active)
SELECT 'International Flavors', 'Explore the world through food — every month, a new culture and its signature dishes to cook and enjoy.', 8,c.city_id, c.state_id, a.account_id, 'A' FROM accounts a JOIN city c ON a.city_id = c.city_id WHERE a.nick_name = 'KSanon';
INSERT INTO clubs (name, description, category_id, city_id, state_id, creator_id, active)
SELECT 'Meal Prep Mastery', 'Learn how to prep meals for the week, saving time and eating healthier with nutritious, well-balanced recipes.', 8,c.city_id, c.state_id, a.account_id, 'A' FROM accounts a JOIN city c ON a.city_id = c.city_id WHERE a.nick_name = 'JAbraham';
INSERT INTO clubs (name, description, category_id, city_id, state_id, creator_id, active)
SELECT 'Creative Crafters', 'A space for all types of crafting, from scrapbooking to knitting and DIY home decor projects.', 9,c.city_id, c.state_id, a.account_id, 'A' FROM accounts a JOIN city c ON a.city_id = c.city_id WHERE a.nick_name = 'NeoReeves';
INSERT INTO clubs (name, description, category_id, city_id, state_id, creator_id, active)
SELECT 'Beading and Beyond', 'Learn the art of beadwork, jewelry making, and creating stunning accessories with beads, wires, and tools.', 9,c.city_id, c.state_id, a.account_id, 'A' FROM accounts a JOIN city c ON a.city_id = c.city_id WHERE a.nick_name = 'BatBale';
INSERT INTO clubs (name, description, category_id, city_id, state_id, creator_id, active)
SELECT 'Knitting Circle', 'Gather together for a cozy time of knitting, crocheting, and sharing projects, patterns, and ideas.', 9,c.city_id, c.state_id, a.account_id, 'A' FROM accounts a JOIN city c ON a.city_id = c.city_id WHERE a.nick_name = 'KenGos';
INSERT INTO clubs (name, description, category_id, city_id, state_id, creator_id, active)
SELECT 'Upcycled Artworks', 'Transform everyday items into creative masterpieces with the art of upcycling and sustainable crafting practices.', 9,c.city_id, c.state_id, a.account_id, 'A' FROM accounts a JOIN city c ON a.city_id = c.city_id WHERE a.nick_name = 'QuietEmily';
INSERT INTO clubs (name, description, category_id, city_id, state_id, creator_id, active)
SELECT 'Embroidery Enthusiasts', 'A club for those who love embroidery, from beginner stitches to complex designs and advanced techniques.', 9,c.city_id, c.state_id, a.account_id, 'A' FROM accounts a JOIN city c ON a.city_id = c.city_id WHERE a.nick_name = 'Zefron';
INSERT INTO clubs (name, description, category_id, city_id, state_id, creator_id, active)
SELECT 'Rhythmic Revolution', 'From salsa to swing, join this club to learn and enjoy various dance styles with regular classes and social nights.', 10,c.city_id, c.state_id, a.account_id, 'A' FROM accounts a JOIN city c ON a.city_id = c.city_id WHERE a.nick_name = 'ThorChris';
INSERT INTO clubs (name, description, category_id, city_id, state_id, creator_id, active)
SELECT 'Hip Hop Hustle', 'For those who love the beats and moves of hip-hop, this group offers a blend of choreography and freestyle dance.', 10,c.city_id, c.state_id, a.account_id, 'A' FROM accounts a JOIN city c ON a.city_id = c.city_id WHERE a.nick_name = 'NPort';
INSERT INTO clubs (name, description, category_id, city_id, state_id, creator_id, active)
SELECT 'Ballet Barre', 'A place for dancers to practice and perfect the art of ballet, from beginners to advanced levels.', 10,c.city_id, c.state_id, a.account_id, 'A' FROM accounts a JOIN city c ON a.city_id = c.city_id WHERE a.nick_name = 'NeoReeves';
INSERT INTO clubs (name, description, category_id, city_id, state_id, creator_id, active)
SELECT 'Zumba Party', 'A fun, energetic club where members can enjoy high-intensity workouts that combine dance and fitness through Zumba.', 10,c.city_id, c.state_id, a.account_id, 'A' FROM accounts a JOIN city c ON a.city_id = c.city_id WHERE a.nick_name = 'HermiWat';
INSERT INTO clubs (name, description, category_id, city_id, state_id, creator_id, active)
SELECT 'Contemporary Dance Collective', 'Focused on modern, expressive dance techniques, this club encourages free movement and creativity.', 10,c.city_id, c.state_id, a.account_id, 'A' FROM accounts a JOIN city c ON a.city_id = c.city_id WHERE a.nick_name = 'AmyA';
INSERT INTO clubs (name, description, category_id, city_id, state_id, creator_id, active)
SELECT 'The Logical Argument', 'A club where passionate debaters engage in discussions and debates on a wide range of topics, sharpening reasoning and communication skills.', 11,c.city_id, c.state_id, a.account_id, 'A' FROM accounts a JOIN city c ON a.city_id = c.city_id WHERE a.nick_name = 'LeoKing';
INSERT INTO clubs (name, description, category_id, city_id, state_id, creator_id, active)
SELECT 'Rhetoric Revolution', 'Focusing on the art of persuasion, this club helps members develop their rhetorical abilities through structured debates and public speaking.', 11,c.city_id, c.state_id, a.account_id, 'A' FROM accounts a JOIN city c ON a.city_id = c.city_id WHERE a.nick_name = 'AKapoor';
INSERT INTO clubs (name, description, category_id, city_id, state_id, creator_id, active)
SELECT 'Political Roundtable', 'A group for those interested in political discourse, exploring different viewpoints through formal debates and discussions.', 11,c.city_id, c.state_id, a.account_id, 'A' FROM accounts a JOIN city c ON a.city_id = c.city_id WHERE a.nick_name = 'JGL';
INSERT INTO clubs (name, description, category_id, city_id, state_id, creator_id, active)
SELECT 'Philosophical Arguments', 'Engage in philosophical debates, examining topics such as ethics, morality, and logic in a structured yet creative environment.', 11,c.city_id, c.state_id, a.account_id, 'A' FROM accounts a JOIN city c ON a.city_id = c.city_id WHERE a.nick_name = 'DuneTim';
INSERT INTO clubs (name, description, category_id, city_id, state_id, creator_id, active)
SELECT 'Debate for Beginners', 'An introductory club for those new to debating, focusing on the fundamentals of argumentation, public speaking, and critical thinking.', 11,c.city_id, c.state_id, a.account_id, 'A' FROM accounts a JOIN city c ON a.city_id = c.city_id WHERE a.nick_name = 'FinnW';
INSERT INTO clubs (name, description, category_id, city_id, state_id, creator_id, active)
SELECT 'Cinematic Explorers', 'For film lovers who appreciate cinema as an art form, this club explores both mainstream and independent films from around the world.', 12,c.city_id, c.state_id, a.account_id, 'A' FROM accounts a JOIN city c ON a.city_id = c.city_id WHERE a.nick_name = 'KKapoor';
INSERT INTO clubs (name, description, category_id, city_id, state_id, creator_id, active)
SELECT 'Classic Movie Buffs', 'Focused on timeless classics, this club watches and discusses films from the golden age of Hollywood and beyond.', 12,c.city_id, c.state_id, a.account_id, 'A' FROM accounts a JOIN city c ON a.city_id = c.city_id WHERE a.nick_name = 'HermiWat';
INSERT INTO clubs (name, description, category_id, city_id, state_id, creator_id, active)
SELECT 'Documentary Discourse', 'A club dedicated to documentary films, exploring real-world issues, people, and stories through film.', 12,c.city_id, c.state_id, a.account_id, 'A' FROM accounts a JOIN city c ON a.city_id = c.city_id WHERE a.nick_name = 'PotterDan';
INSERT INTO clubs (name, description, category_id, city_id, state_id, creator_id, active)
SELECT 'Action Flick Fanatics', 'For fans of thrilling action films, this club watches, critiques, and celebrates the best action-packed movies.', 12,c.city_id, c.state_id, a.account_id, 'A' FROM accounts a JOIN city c ON a.city_id = c.city_id WHERE a.nick_name = 'AntPaul';
INSERT INTO clubs (name, description, category_id, city_id, state_id, creator_id, active)
SELECT 'Indie Film Society', 'A space for independent filmmakers and film buffs to discuss indie films, review emerging talents, and explore lesser-known gems.', 12,c.city_id, c.state_id, a.account_id, 'A' FROM accounts a JOIN city c ON a.city_id = c.city_id WHERE a.nick_name = 'MBBMillie';
INSERT INTO clubs (name, description, category_id, city_id, state_id, creator_id, active)
SELECT 'Strength and Conditioning', 'A fitness-focused group for strength training, weightlifting, and muscle building, with expert advice and workouts.', 13,c.city_id, c.state_id, a.account_id, 'A' FROM accounts a JOIN city c ON a.city_id = c.city_id WHERE a.nick_name = 'AnneH';
INSERT INTO clubs (name, description, category_id, city_id, state_id, creator_id, active)
SELECT 'Cardio Crew', 'For those who love high-intensity cardio, join us for running, cycling, and interval training to keep your heart pumping and your body strong.', 13,c.city_id, c.state_id, a.account_id, 'A' FROM accounts a JOIN city c ON a.city_id = c.city_id WHERE a.nick_name = 'ARai';
INSERT INTO clubs (name, description, category_id, city_id, state_id, creator_id, active)
SELECT 'Yoga and Flexibility', 'A peaceful club where members focus on improving flexibility, mindfulness, and balance through yoga and other stretching exercises.', 13,c.city_id, c.state_id, a.account_id, 'A' FROM accounts a JOIN city c ON a.city_id = c.city_id WHERE a.nick_name = 'RKapo';
INSERT INTO clubs (name, description, category_id, city_id, state_id, creator_id, active)
SELECT 'HIIT Warriors', 'High-Intensity Interval Training (HIIT) enthusiasts who meet to challenge each other with quick and intense workout routines.', 13,c.city_id, c.state_id, a.account_id, 'A' FROM accounts a JOIN city c ON a.city_id = c.city_id WHERE a.nick_name = 'KKaif';
INSERT INTO clubs (name, description, category_id, city_id, state_id, creator_id, active)
SELECT 'Fitness for Life', 'A wellness club focusing on creating sustainable fitness habits, from proper nutrition to exercise regimens that improve long-term health.', 13,c.city_id, c.state_id, a.account_id, 'A' FROM accounts a JOIN city c ON a.city_id = c.city_id WHERE a.nick_name = 'PChops';
INSERT INTO clubs (name, description, category_id, city_id, state_id, creator_id, active)
SELECT 'The Game Masters', 'A community of gamers who come together to play and discuss all genres of video games, from console to PC gaming.', 14,c.city_id, c.state_id, a.account_id, 'A' FROM accounts a JOIN city c ON a.city_id = c.city_id WHERE a.nick_name = 'JAbraham';
INSERT INTO clubs (name, description, category_id, city_id, state_id, creator_id, active)
SELECT 'Retro Game Vault', 'For those who love the nostalgia of retro gaming, this club celebrates classic video games from the 80s and 90s.', 14,c.city_id, c.state_id, a.account_id, 'A' FROM accounts a JOIN city c ON a.city_id = c.city_id WHERE a.nick_name = 'CaptainBrie';
INSERT INTO clubs (name, description, category_id, city_id, state_id, creator_id, active)
SELECT 'Esports Elite', 'For competitive gamers, this club organizes tournaments, events, and discussions on improving esports performance and strategy.', 14,c.city_id, c.state_id, a.account_id, 'A' FROM accounts a JOIN city c ON a.city_id = c.city_id WHERE a.nick_name = 'MadsM';
INSERT INTO clubs (name, description, category_id, city_id, state_id, creator_id, active)
SELECT 'Tabletop Tavern', 'Join us for board games, card games, and role-playing games! Meet new players and take part in epic tabletop adventures.', 14,c.city_id, c.state_id, a.account_id, 'A' FROM accounts a JOIN city c ON a.city_id = c.city_id WHERE a.nick_name = 'OSy';
INSERT INTO clubs (name, description, category_id, city_id, state_id, creator_id, active)
SELECT 'Casual Gamers Club', 'For those who enjoy gaming as a relaxing hobby, this club is all about playing for fun, socializing, and sharing gaming experiences.', 14,c.city_id, c.state_id, a.account_id, 'A' FROM accounts a JOIN city c ON a.city_id = c.city_id WHERE a.nick_name = 'JBardem';
INSERT INTO clubs (name, description, category_id, city_id, state_id, creator_id, active)
SELECT 'Green Thumbs Collective', 'A club for plant enthusiasts who come together to learn about gardening, share tips, and grow beautiful plants.', 15,c.city_id, c.state_id, a.account_id, 'A' FROM accounts a JOIN city c ON a.city_id = c.city_id WHERE a.nick_name = 'TheRock';
INSERT INTO clubs (name, description, category_id, city_id, state_id, creator_id, active)
SELECT 'Urban Growers', 'Focus on urban gardening techniques, including vertical farming, hydroponics, and growing in small spaces.', 15,c.city_id, c.state_id, a.account_id, 'A' FROM accounts a JOIN city c ON a.city_id = c.city_id WHERE a.nick_name = 'NPort';
INSERT INTO clubs (name, description, category_id, city_id, state_id, creator_id, active)
SELECT 'Sustainable Gardens', 'A group dedicated to sustainable gardening practices, including permaculture, composting, and organic methods.', 15,c.city_id, c.state_id, a.account_id, 'A' FROM accounts a JOIN city c ON a.city_id = c.city_id WHERE a.nick_name = 'WonderGal';
INSERT INTO clubs (name, description, category_id, city_id, state_id, creator_id, active)
SELECT 'Flower Fanatics', 'For those passionate about flowers, this club focuses on flower gardening, floral arrangements, and creating vibrant outdoor spaces.', 15,c.city_id, c.state_id, a.account_id, 'A' FROM accounts a JOIN city c ON a.city_id = c.city_id WHERE a.nick_name = 'JGL';
INSERT INTO clubs (name, description, category_id, city_id, state_id, creator_id, active)
SELECT 'Herb Lovers Society', 'This club focuses on growing and using herbs, whether for culinary, medicinal, or aromatic purposes.', 15,c.city_id, c.state_id, a.account_id, 'A' FROM accounts a JOIN city c ON a.city_id = c.city_id WHERE a.nick_name = 'PascalP';
INSERT INTO clubs (name, description, category_id, city_id, state_id, creator_id, active)
SELECT 'Trail Blazers', 'For hiking enthusiasts who enjoy exploring scenic trails and nature hikes, this club meets regularly for outdoor adventures.', 16,c.city_id, c.state_id, a.account_id, 'A' FROM accounts a JOIN city c ON a.city_id = c.city_id WHERE a.nick_name = 'ACurtis';
INSERT INTO clubs (name, description, category_id, city_id, state_id, creator_id, active)
SELECT 'Mountain Mavericks', 'A club for hikers who love conquering mountain trails, challenging their endurance, and exploring rugged landscapes.', 16,c.city_id, c.state_id, a.account_id, 'A' FROM accounts a JOIN city c ON a.city_id = c.city_id WHERE a.nick_name = 'CaptainBrie';
INSERT INTO clubs (name, description, category_id, city_id, state_id, creator_id, active)
SELECT 'Nature Walkers', 'Focuses on leisurely hikes in nature, perfect for beginners or those looking to enjoy peaceful walks through forests and parks.', 16,c.city_id, c.state_id, a.account_id, 'A' FROM accounts a JOIN city c ON a.city_id = c.city_id WHERE a.nick_name = 'WolverineHugh';
INSERT INTO clubs (name, description, category_id, city_id, state_id, creator_id, active)
SELECT 'Weekend Wanderers', 'A weekend club that organizes day-long hikes to discover hidden trails and share experiences with fellow hiking enthusiasts.', 16,c.city_id, c.state_id, a.account_id, 'A' FROM accounts a JOIN city c ON a.city_id = c.city_id WHERE a.nick_name = 'PCruz';
INSERT INTO clubs (name, description, category_id, city_id, state_id, creator_id, active)
SELECT 'Backcountry Explorers', 'For those who enjoy more remote hiking destinations, this club takes on backcountry treks, off the beaten path, in nature’s untouched beauty.', 16,c.city_id, c.state_id, a.account_id, 'A' FROM accounts a JOIN city c ON a.city_id = c.city_id WHERE a.nick_name = 'LSeydoux';
INSERT INTO clubs (name, description, category_id, city_id, state_id, creator_id, active)
SELECT 'Polyglot Society', 'A club for language lovers looking to expand their vocabulary and practice multiple languages through conversations and lessons.', 17,c.city_id, c.state_id, a.account_id, 'A' FROM accounts a JOIN city c ON a.city_id = c.city_id WHERE a.nick_name = 'CapEvans';
INSERT INTO clubs (name, description, category_id, city_id, state_id, creator_id, active)
SELECT 'Cultural Exchange Club', 'Connect with people from different countries, learn about their languages, cultures, and customs, and improve your linguistic skills.', 17,c.city_id, c.state_id, a.account_id, 'A' FROM accounts a JOIN city c ON a.city_id = c.city_id WHERE a.nick_name = 'TheRock';
INSERT INTO clubs (name, description, category_id, city_id, state_id, creator_id, active)
SELECT 'English Conversation Circle', 'A group for non-native English speakers who wish to improve their fluency through informal discussions and language games.', 17,c.city_id, c.state_id, a.account_id, 'A' FROM accounts a JOIN city c ON a.city_id = c.city_id WHERE a.nick_name = 'AnneH';
INSERT INTO clubs (name, description, category_id, city_id, state_id, creator_id, active)
SELECT 'Spanish Speakers Unite', 'For Spanish learners and speakers, this club gathers to practice speaking, reading, and writing in Spanish in an immersive environment.', 17,c.city_id, c.state_id, a.account_id, 'A' FROM accounts a JOIN city c ON a.city_id = c.city_id WHERE a.nick_name = 'PotterDan';
INSERT INTO clubs (name, description, category_id, city_id, state_id, creator_id, active)
SELECT 'French & Beyond', 'Learn the beauty of the French language and culture with a focus on pronunciation, grammar, and conversations in an interactive setting.', 17,c.city_id, c.state_id, a.account_id, 'A' FROM accounts a JOIN city c ON a.city_id = c.city_id WHERE a.nick_name = 'AmyA';
INSERT INTO clubs (name, description, category_id, city_id, state_id, creator_id, active)
SELECT 'Karate Kids', 'A family-friendly club where beginners and experienced practitioners alike learn the basics of Karate, discipline, and self-defense.', 18,c.city_id, c.state_id, a.account_id, 'A' FROM accounts a JOIN city c ON a.city_id = c.city_id WHERE a.nick_name = 'IronBob';
INSERT INTO clubs (name, description, category_id, city_id, state_id, creator_id, active)
SELECT 'Judo Champions', 'Focused on mastering Judo techniques, this club practices throws, holds, and grappling for self-defense and competitive training.', 18,c.city_id, c.state_id, a.account_id, 'A' FROM accounts a JOIN city c ON a.city_id = c.city_id WHERE a.nick_name = 'SaiRon';
INSERT INTO clubs (name, description, category_id, city_id, state_id, creator_id, active)
SELECT 'Taekwondo Tigers', 'For those interested in learning Taekwondo, this club emphasizes flexibility, power, and respect through structured classes and sparring.', 18,c.city_id, c.state_id, a.account_id, 'A' FROM accounts a JOIN city c ON a.city_id = c.city_id WHERE a.nick_name = 'CillMurph';
INSERT INTO clubs (name, description, category_id, city_id, state_id, creator_id, active)
SELECT 'Brazilian Jiu-Jitsu Brotherhood', 'This club is for those interested in Brazilian Jiu-Jitsu, with a focus on ground fighting techniques and submissions.', 18,c.city_id, c.state_id, a.account_id, 'A' FROM accounts a JOIN city c ON a.city_id = c.city_id WHERE a.nick_name = 'SRKhan';
INSERT INTO clubs (name, description, category_id, city_id, state_id, creator_id, active)
SELECT 'Kung Fu Warriors', 'A traditional martial arts club that explores various Kung Fu styles, focusing on movement, forms, and meditation practices.', 18,c.city_id, c.state_id, a.account_id, 'A' FROM accounts a JOIN city c ON a.city_id = c.city_id WHERE a.nick_name = 'MBajpayee';
INSERT INTO clubs (name, description, category_id, city_id, state_id, creator_id, active)
SELECT 'The Sound Collective', 'A community of musicians and music lovers who come together to create, perform, and share original compositions and covers.', 19,c.city_id, c.state_id, a.account_id, 'A' FROM accounts a JOIN city c ON a.city_id = c.city_id WHERE a.nick_name = 'RonGrint';
INSERT INTO clubs (name, description, category_id, city_id, state_id, creator_id, active)
SELECT 'Jazz Jams', 'For fans of jazz, this club hosts jam sessions and workshops where members can explore improvisation, rhythm, and melody in jazz music.', 19,c.city_id, c.state_id, a.account_id, 'A' FROM accounts a JOIN city c ON a.city_id = c.city_id WHERE a.nick_name = 'MavCruise';
INSERT INTO clubs (name, description, category_id, city_id, state_id, creator_id, active)
SELECT 'Rock and Roll Revival', 'Focused on rock music, this club brings together musicians, fans, and aspiring performers to celebrate and create rock anthems.', 19,c.city_id, c.state_id, a.account_id, 'A' FROM accounts a JOIN city c ON a.city_id = c.city_id WHERE a.nick_name = 'QuietEmily';
INSERT INTO clubs (name, description, category_id, city_id, state_id, creator_id, active)
SELECT 'Classical Harmony', 'A club for classical music enthusiasts, this group listens to, performs, and discusses works from legendary composers such as Bach and Beethoven.', 19,c.city_id, c.state_id, a.account_id, 'A' FROM accounts a JOIN city c ON a.city_id = c.city_id WHERE a.nick_name = 'BourneMatt';
INSERT INTO clubs (name, description, category_id, city_id, state_id, creator_id, active)
SELECT 'Electronic Beats Society', 'A space for electronic music producers and fans to create, mix, and explore the art of sound through electronic music genres.', 19,c.city_id, c.state_id, a.account_id, 'A' FROM accounts a JOIN city c ON a.city_id = c.city_id WHERE a.nick_name = 'SMalhotra';
INSERT INTO clubs (name, description, category_id, city_id, state_id, creator_id, active)
SELECT 'Shutterbugs', 'For amateur and professional photographers alike, this club meets to discuss techniques, share portfolios, and participate in photo walks.', 20,c.city_id, c.state_id, a.account_id, 'A' FROM accounts a JOIN city c ON a.city_id = c.city_id WHERE a.nick_name = 'ScarJo';
INSERT INTO clubs (name, description, category_id, city_id, state_id, creator_id, active)
SELECT 'Lens & Light', 'A photography club focused on mastering lighting techniques, including studio lighting, natural light, and creative lighting setups.', 20,c.city_id, c.state_id, a.account_id, 'A' FROM accounts a JOIN city c ON a.city_id = c.city_id WHERE a.nick_name = 'JAbraham';
INSERT INTO clubs (name, description, category_id, city_id, state_id, creator_id, active)
SELECT 'Portrait Perfection', 'A group dedicated to portrait photography, learning how to capture the best expressions, poses, and moods in people.', 20,c.city_id, c.state_id, a.account_id, 'A' FROM accounts a JOIN city c ON a.city_id = c.city_id WHERE a.nick_name = 'JOrtega';
INSERT INTO clubs (name, description, category_id, city_id, state_id, creator_id, active)
SELECT 'Nature Photography Society', 'For nature lovers who enjoy capturing landscapes, wildlife, and plant life, this club organizes photo excursions into nature.', 20,c.city_id, c.state_id, a.account_id, 'A' FROM accounts a JOIN city c ON a.city_id = c.city_id WHERE a.nick_name = 'DSalmaan';
INSERT INTO clubs (name, description, category_id, city_id, state_id, creator_id, active)
SELECT 'Photo Editing Wizards', 'A club focused on the art of photo editing, using software like Photoshop to enhance and manipulate images to their full potential.', 20,c.city_id, c.state_id, a.account_id, 'A' FROM accounts a JOIN city c ON a.city_id = c.city_id WHERE a.nick_name = 'AKhurrana';
INSERT INTO clubs (name, description, category_id, city_id, state_id, creator_id, active)
SELECT 'RoboMasters', 'A club for aspiring engineers and innovators who love building and programming robots, with regular competitions and challenges.', 21,c.city_id, c.state_id, a.account_id, 'A' FROM accounts a JOIN city c ON a.city_id = c.city_id WHERE a.nick_name = 'PCruz';
INSERT INTO clubs (name, description, category_id, city_id, state_id, creator_id, active)
SELECT 'Bot Builders', 'This club focuses on the design, construction, and programming of robots for a wide range of applications, from practical to experimental.', 21,c.city_id, c.state_id, a.account_id, 'A' FROM accounts a JOIN city c ON a.city_id = c.city_id WHERE a.nick_name = 'RonGrint';
INSERT INTO clubs (name, description, category_id, city_id, state_id, creator_id, active)
SELECT 'TechBot Society', 'For members interested in using technology and robotics to solve real-world problems, this club emphasizes innovation and automation.', 21,c.city_id, c.state_id, a.account_id, 'A' FROM accounts a JOIN city c ON a.city_id = c.city_id WHERE a.nick_name = 'VHud';
INSERT INTO clubs (name, description, category_id, city_id, state_id, creator_id, active)
SELECT 'Robo Revolution', 'Dedicated to learning and experimenting with the latest robotics technologies, from AI-powered bots to robotic limbs and drones.', 21,c.city_id, c.state_id, a.account_id, 'A' FROM accounts a JOIN city c ON a.city_id = c.city_id WHERE a.nick_name = 'NateD';
INSERT INTO clubs (name, description, category_id, city_id, state_id, creator_id, active)
SELECT 'Junior Robotics League', 'A group for younger members who want to get involved in robotics, where they learn the basics of building and programming robots.', 21,c.city_id, c.state_id, a.account_id, 'A' FROM accounts a JOIN city c ON a.city_id = c.city_id WHERE a.nick_name = 'MBBMillie';
INSERT INTO clubs (name, description, category_id, city_id, state_id, creator_id, active)
SELECT 'Scientific Explorers', 'A club for curious minds who love conducting experiments, exploring new scientific concepts, and participating in research projects.', 22,c.city_id, c.state_id, a.account_id, 'A' FROM accounts a JOIN city c ON a.city_id = c.city_id WHERE a.nick_name = 'OSy';
INSERT INTO clubs (name, description, category_id, city_id, state_id, creator_id, active)
SELECT 'Chemistry Club', 'Dedicated to the fascinating world of chemistry, this club hosts experiments, discussions, and presentations on chemical reactions and theories.', 22,c.city_id, c.state_id, a.account_id, 'A' FROM accounts a JOIN city c ON a.city_id = c.city_id WHERE a.nick_name = 'LSeydoux';
INSERT INTO clubs (name, description, category_id, city_id, state_id, creator_id, active)
SELECT 'Physics Enthusiasts', 'Focused on understanding the fundamental laws of physics, this group discusses everything from quantum mechanics to space-time theory.', 22,c.city_id, c.state_id, a.account_id, 'A' FROM accounts a JOIN city c ON a.city_id = c.city_id WHERE a.nick_name = 'ABhatt';
INSERT INTO clubs (name, description, category_id, city_id, state_id, creator_id, active)
SELECT 'Astronomy Explorers', 'For those who love the night sky, this club gathers for stargazing, learning about constellations, and participating in space observation events.', 22,c.city_id, c.state_id, a.account_id, 'A' FROM accounts a JOIN city c ON a.city_id = c.city_id WHERE a.nick_name = 'KKapoor';
INSERT INTO clubs (name, description, category_id, city_id, state_id, creator_id, active)
SELECT 'Environmental Science Society', 'A club for those interested in environmental issues, this group works on projects focused on sustainability, conservation, and ecology.', 22,c.city_id, c.state_id, a.account_id, 'A' FROM accounts a JOIN city c ON a.city_id = c.city_id WHERE a.nick_name = 'MBJordan';
INSERT INTO clubs (name, description, category_id, city_id, state_id, creator_id, active)
SELECT 'Green Earth Movement', 'For those passionate about sustainability and the environment, this club focuses on reducing waste, conserving energy, and promoting eco-friendly practices.', 23,c.city_id, c.state_id, a.account_id, 'A' FROM accounts a JOIN city c ON a.city_id = c.city_id WHERE a.nick_name = 'MBJordan';
INSERT INTO clubs (name, description, category_id, city_id, state_id, creator_id, active)
SELECT 'Eco Innovators', 'A club for inventors and entrepreneurs interested in developing sustainable solutions to environmental challenges like climate change and pollution.', 23,c.city_id, c.state_id, a.account_id, 'A' FROM accounts a JOIN city c ON a.city_id = c.city_id WHERE a.nick_name = 'ASharma';
INSERT INTO clubs (name, description, category_id, city_id, state_id, creator_id, active)
SELECT 'Recycling Rangers', 'This club works on creative recycling projects, teaching members how to repurpose materials and reduce the environmental impact of waste.', 23,c.city_id, c.state_id, a.account_id, 'A' FROM accounts a JOIN city c ON a.city_id = c.city_id WHERE a.nick_name = 'AKhurrana';
INSERT INTO clubs (name, description, category_id, city_id, state_id, creator_id, active)
SELECT 'Zero Waste Warriors', 'Focused on achieving a zero-waste lifestyle, this club promotes composting, reusing materials, and reducing consumption.', 23,c.city_id, c.state_id, a.account_id, 'A' FROM accounts a JOIN city c ON a.city_id = c.city_id WHERE a.nick_name = 'SKapoor';
INSERT INTO clubs (name, description, category_id, city_id, state_id, creator_id, active)
SELECT 'Solar Power Pioneers', 'Dedicated to renewable energy, especially solar power, this group works on solar-powered projects and educates others about sustainable energy solutions.', 23,c.city_id, c.state_id, a.account_id, 'A' FROM accounts a JOIN city c ON a.city_id = c.city_id WHERE a.nick_name = 'AKhurrana';
INSERT INTO clubs (name, description, category_id, city_id, state_id, creator_id, active)
SELECT 'Tech Innovators', 'For technology enthusiasts, this club explores the latest trends in tech, from artificial intelligence to blockchain and beyond.', 24,c.city_id, c.state_id, a.account_id, 'A' FROM accounts a JOIN city c ON a.city_id = c.city_id WHERE a.nick_name = 'CapEvans';
INSERT INTO clubs (name, description, category_id, city_id, state_id, creator_id, active)
SELECT 'Code Creators', 'A programming-focused club where members work on coding projects, learn new languages, and share ideas on software development.', 24,c.city_id, c.state_id, a.account_id, 'A' FROM accounts a JOIN city c ON a.city_id = c.city_id WHERE a.nick_name = 'JLaw';
INSERT INTO clubs (name, description, category_id, city_id, state_id, creator_id, active)
SELECT 'Gaming & Development', 'For aspiring game developers, this club combines gaming culture with the technical skills needed to create interactive experiences and games.', 24,c.city_id, c.state_id, a.account_id, 'A' FROM accounts a JOIN city c ON a.city_id = c.city_id WHERE a.nick_name = 'KenGos';
INSERT INTO clubs (name, description, category_id, city_id, state_id, creator_id, active)
SELECT 'Cybersecurity Defenders', 'A group dedicated to learning about cybersecurity and how to protect systems and networks from hacking and malicious attacks.', 24,c.city_id, c.state_id, a.account_id, 'A' FROM accounts a JOIN city c ON a.city_id = c.city_id WHERE a.nick_name = 'NateD';
INSERT INTO clubs (name, description, category_id, city_id, state_id, creator_id, active)
SELECT 'AI & Robotics Hub', 'This club brings together those interested in artificial intelligence and robotics, exploring machine learning, neural networks, and autonomous systems.', 24,c.city_id, c.state_id, a.account_id, 'A' FROM accounts a JOIN city c ON a.city_id = c.city_id WHERE a.nick_name = 'WolverineHugh';
INSERT INTO clubs (name, description, category_id, city_id, state_id, creator_id, active)
SELECT 'Creative Writers', 'A club for writers of all kinds, whether poetry, short stories, or novels, this group focuses on creativity, feedback, and sharing work.', 25,c.city_id, c.state_id, a.account_id, 'A' FROM accounts a JOIN city c ON a.city_id = c.city_id WHERE a.nick_name = 'LeoKing';
INSERT INTO clubs (name, description, category_id, city_id, state_id, creator_id, active)
SELECT 'Poetry Society', 'For poetry lovers, this club meets to write, read, and discuss poems, exploring different styles, forms, and techniques.', 25,c.city_id, c.state_id, a.account_id, 'A' FROM accounts a JOIN city c ON a.city_id = c.city_id WHERE a.nick_name = 'LetoJ';
INSERT INTO clubs (name, description, category_id, city_id, state_id, creator_id, active)
SELECT 'Script Writers Guild', 'This club brings together screenwriters and playwrights, offering workshops and critiques for those interested in writing for film and theater.', 25,c.city_id, c.state_id, a.account_id, 'A' FROM accounts a JOIN city c ON a.city_id = c.city_id WHERE a.nick_name = 'JessC';
INSERT INTO clubs (name, description, category_id, city_id, state_id, creator_id, active)
SELECT 'Fantasy Fiction Society', 'For fans of fantasy, this club discusses and creates works of fantasy fiction, from world-building to character development and plot creation.', 25,c.city_id, c.state_id, a.account_id, 'A' FROM accounts a JOIN city c ON a.city_id = c.city_id WHERE a.nick_name = 'BDHoward';
INSERT INTO clubs (name, description, category_id, city_id, state_id, creator_id, active)
SELECT 'Journalism and Media Club', 'A group for budding journalists and media enthusiasts who want to explore writing for newspapers, magazines, and online platforms.', 25,c.city_id, c.state_id, a.account_id, 'A' FROM accounts a JOIN city c ON a.city_id = c.city_id WHERE a.nick_name = 'SMarceau';
INSERT INTO clubs (name, description, category_id, city_id, state_id, creator_id, active)
SELECT 'Stage Stars', 'A club for aspiring actors who are passionate about performing on stage, where members engage in workshops, performances, and acting exercises.', 26,c.city_id, c.state_id, a.account_id, 'A' FROM accounts a JOIN city c ON a.city_id = c.city_id WHERE a.nick_name = 'IronBob';
INSERT INTO clubs (name, description, category_id, city_id, state_id, creator_id, active)
SELECT 'Drama Enthusiasts', 'This club is dedicated to the art of drama, bringing together actors, directors, and writers to create compelling stories and performances.', 26,c.city_id, c.state_id, a.account_id, 'A' FROM accounts a JOIN city c ON a.city_id = c.city_id WHERE a.nick_name = 'SpideyTom';
INSERT INTO clubs (name, description, category_id, city_id, state_id, creator_id, active)
SELECT 'Theater Arts Society', 'For those interested in theater arts, this club explores the various aspects of acting, stage design, and the history of dramatic performances.', 26,c.city_id, c.state_id, a.account_id, 'A' FROM accounts a JOIN city c ON a.city_id = c.city_id WHERE a.nick_name = 'CillMurph';
INSERT INTO clubs (name, description, category_id, city_id, state_id, creator_id, active)
SELECT 'Improv Acting Troupe', 'Focused on improvisational theater, this group helps actors develop spontaneity and creativity, performing unscripted scenes and skits.', 26,c.city_id, c.state_id, a.account_id, 'A' FROM accounts a JOIN city c ON a.city_id = c.city_id WHERE a.nick_name = 'ARai';
INSERT INTO clubs (name, description, category_id, city_id, state_id, creator_id, active)
SELECT 'Shakespeare Society', 'A club for lovers of classic theater, especially the works of Shakespeare, where members perform and study his plays and their modern adaptations.', 26,c.city_id, c.state_id, a.account_id, 'A' FROM accounts a JOIN city c ON a.city_id = c.city_id WHERE a.nick_name = 'JAbraham';
COMMIT;

# add the creator to the club.
INSERT INTO userclubs (account_id, club_id, active) SELECT c.creator_id, c.club_id, 'A' FROM clubs c;
COMMIT;

# add random users to clubs
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'LeoKing' AND c.name = 'Action Flick Fanatics'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'FAkhtar' AND c.name = 'Action Flick Fanatics'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'OSy' AND c.name = 'Action Flick Fanatics'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'SAKhan' AND c.name = 'Action Flick Fanatics'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'NeoReeves' AND c.name = 'Action Flick Fanatics'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'CWaltz' AND c.name = 'Action Flick Fanatics'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'FloP' AND c.name = 'Action Flick Fanatics'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'KenGos' AND c.name = 'AI & Robotics Hub'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'Tabz' AND c.name = 'AI & Robotics Hub'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'BDHoward' AND c.name = 'Anime Sketch Circle'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'Johnny' AND c.name = 'Anime Sketch Circle'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'ThorChris' AND c.name = 'Anime Sketch Circle'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'WonderGal' AND c.name = 'Anime Sketch Circle'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'JOrtega' AND c.name = 'Anime Sketch Circle'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'DSalmaan' AND c.name = 'Anime Sketch Circle'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'ASharma' AND c.name = 'Astronomy Explorers'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'AntPaul' AND c.name = 'Astronomy Explorers'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'SMarceau' AND c.name = 'Astronomy Explorers'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'DuneTim' AND c.name = 'Astronomy Explorers'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'PTripathi' AND c.name = 'Astronomy Explorers'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'JessC' AND c.name = 'Astronomy Explorers'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'NateD' AND c.name = 'Astronomy Explorers'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'IKhan' AND c.name = 'Astrophotography Club'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'PChopra' AND c.name = 'Astrophotography Club'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'MBBMillie' AND c.name = 'Astrophotography Club'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'CillMurph' AND c.name = 'Astrophotography Club'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'PChops' AND c.name = 'Astrophotography Club'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'MBajpayee' AND c.name = 'Backcountry Explorers'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'CaptainBrie' AND c.name = 'Backcountry Explorers'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'ZQueen' AND c.name = 'Backcountry Explorers'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'PotterDan' AND c.name = 'Backcountry Explorers'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'NFakhri' AND c.name = 'Baking Brigade'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'HermiWat' AND c.name = 'Baking Brigade'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'Tabz' AND c.name = 'Baking Brigade'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'KKaif' AND c.name = 'Baking Brigade'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'PChops' AND c.name = 'Baking Brigade'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'RonGrint' AND c.name = 'Baking Brigade'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'WolverineHugh' AND c.name = 'Baking Brigade'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'RDeshmukh' AND c.name = 'Ballet Barre'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'VHud' AND c.name = 'Ballet Barre'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'FloP' AND c.name = 'Ballet Barre'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'ZQueen' AND c.name = 'Beading and Beyond'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'OSy' AND c.name = 'Beading and Beyond'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'EmStoner' AND c.name = 'Beading and Beyond'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'NSchnapp' AND c.name = 'Beading and Beyond'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'JLaw' AND c.name = 'Board Game Designers Guild'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'Tabz' AND c.name = 'Board Game Designers Guild'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'ABhatt' AND c.name = 'Board Game Designers Guild'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'PCruz' AND c.name = 'Board Game Designers Guild'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'HermiWat' AND c.name = 'Board Game Designers Guild'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'SKapoor' AND c.name = 'Board Game Designers Guild'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'TPannu' AND c.name = 'Board Game Designers Guild'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'ASharma' AND c.name = 'Bot Builders'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'MBJordan' AND c.name = 'Bot Builders'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'SMarceau' AND c.name = 'Bot Builders'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'KalDan' AND c.name = 'Brazilian Jiu-Jitsu Brotherhood'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'VBalan' AND c.name = 'Brazilian Jiu-Jitsu Brotherhood'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'CaptainBrie' AND c.name = 'Brazilian Jiu-Jitsu Brotherhood'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'SaiRon' AND c.name = 'Brazilian Jiu-Jitsu Brotherhood'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'FloP' AND c.name = 'Brazilian Jiu-Jitsu Brotherhood'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'NSid' AND c.name = 'Brazilian Jiu-Jitsu Brotherhood'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'LeoKing' AND c.name = 'Car Photography Collective'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'PChops' AND c.name = 'Car Photography Collective'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'WonderGal' AND c.name = 'Car Photography Collective'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'CaptainBrie' AND c.name = 'Car Photography Collective'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'JessC' AND c.name = 'Car Photography Collective'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'CillMurph' AND c.name = 'Car Photography Collective'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'WandaLiz' AND c.name = 'Car Photography Collective'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'NPort' AND c.name = 'Cardio Crew'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'AKapoor' AND c.name = 'Cardio Crew'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'SaiRon' AND c.name = 'Cardio Crew'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'KKaif' AND c.name = 'Cardio Crew'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'QuietEmily' AND c.name = 'Cardio Crew'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'NeoReeves' AND c.name = 'Cardio Crew'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'CillMurph' AND c.name = 'Casual Cardboard'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'ACurtis' AND c.name = 'Casual Cardboard'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'FinnW' AND c.name = 'Casual Gamers Club'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'LetoJ' AND c.name = 'Casual Gamers Club'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'ZQueen' AND c.name = 'Casual Gamers Club'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'KalDan' AND c.name = 'Casual Gamers Club'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'TitanKate' AND c.name = 'Casual Gamers Club'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'HermiWat' AND c.name = 'Casual Gamers Club'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'NeoReeves' AND c.name = 'Casual Gamers Club'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'KalDan' AND c.name = 'Checkmate Collective'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'EmStoner' AND c.name = 'Checkmate Collective'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'LetoJ' AND c.name = 'Checkmate Collective'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'VDhawan' AND c.name = 'Checkmate Collective'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'PTripathi' AND c.name = 'Chemistry Club'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'WonderGal' AND c.name = 'Chemistry Club'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'OSy' AND c.name = 'Chemistry Club'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'Johnny' AND c.name = 'Chemistry Club'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'KKapoor' AND c.name = 'Chemistry Club'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'QuietEmily' AND c.name = 'Chemistry Club'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'VDhawan' AND c.name = 'Chemistry Club'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'AmyA' AND c.name = 'Chemistry Club'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'PChops' AND c.name = 'Chemistry Club'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'KalDan' AND c.name = 'Chess for Beginners'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'NFakhri' AND c.name = 'Chess for Beginners'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'JBardem' AND c.name = 'Cinematic Explorers'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'CaptainBrie' AND c.name = 'Cinematic Explorers'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'JAbraham' AND c.name = 'Cinematic Explorers'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'FinnW' AND c.name = 'Classic Movie Buffs'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'DBruehl' AND c.name = 'Classic Movie Buffs'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'ASharma' AND c.name = 'Classical Harmony'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'JOrtega' AND c.name = 'Classical Harmony'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'FAkhtar' AND c.name = 'Classical Harmony'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'JGL' AND c.name = 'Classical Harmony'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'TPannu' AND c.name = 'Classical Harmony'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'JAbraham' AND c.name = 'Classical Harmony'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'DBruehl' AND c.name = 'Classical Harmony'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'RRao' AND c.name = 'Code Creators'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'DPadu' AND c.name = 'Contemporary Dance Collective'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'JBardem' AND c.name = 'Contemporary Dance Collective'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'ABhatt' AND c.name = 'Contemporary Dance Collective'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'MBajpayee' AND c.name = 'Contemporary Dance Collective'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'CillMurph' AND c.name = 'Contemporary Dance Collective'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'RApte' AND c.name = 'Contemporary Dance Collective'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'AnneH' AND c.name = 'Contemporary Dance Collective'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'KKapoor' AND c.name = 'Contemporary Dance Collective'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'RonGrint' AND c.name = 'Cosmic Curiosity'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'CWaltz' AND c.name = 'Cosmic Curiosity'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'KalDan' AND c.name = 'Cosmic Curiosity'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'IKhan' AND c.name = 'Cosmic Curiosity'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'NateD' AND c.name = 'Cosplay Collective'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'BatBale' AND c.name = 'Cosplay Collective'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'MBBMillie' AND c.name = 'Cosplay Collective'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'VHud' AND c.name = 'Creative Crafters'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'PTripathi' AND c.name = 'Creative Writers'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'RKapo' AND c.name = 'Creative Writers'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'HermiWat' AND c.name = 'Creative Writers'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'NFakhri' AND c.name = 'Creative Writers'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'KKapoor' AND c.name = 'Creative Writers'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'ARai' AND c.name = 'Cultural Exchange Club'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'PotterDan' AND c.name = 'Cultural Exchange Club'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'VDhawan' AND c.name = 'Cultural Exchange Club'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'PChopra' AND c.name = 'Cultural Exchange Club'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'WinR' AND c.name = 'Cybersecurity Defenders'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'DuneTim' AND c.name = 'Cybersecurity Defenders'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'CWaltz' AND c.name = 'Cybersecurity Defenders'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'TheRock' AND c.name = 'Cybersecurity Defenders'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'VDhawan' AND c.name = 'Cybersecurity Defenders'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'PCruz' AND c.name = 'Cybersecurity Defenders'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'FinnW' AND c.name = 'Cybersecurity Defenders'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'Johnny' AND c.name = 'Cybersecurity Defenders'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'ARai' AND c.name = 'Cybersecurity Defenders'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'ThorChris' AND c.name = 'Debate for Beginners'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'AKhurrana' AND c.name = 'Debate for Beginners'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'JAbraham' AND c.name = 'Debate for Beginners'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'KKapoor' AND c.name = 'Debate for Beginners'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'DuneTim' AND c.name = 'Debate for Beginners'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'RRao' AND c.name = 'Digital Art Collective'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'NFakhri' AND c.name = 'Digital Art Collective'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'AKapoor' AND c.name = 'Documentary Discourse'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'FloP' AND c.name = 'Documentary Discourse'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'AquaJay' AND c.name = 'Documentary Discourse'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'OSy' AND c.name = 'Documentary Discourse'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'AVik' AND c.name = 'Documentary Discourse'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'CaptainBrie' AND c.name = 'Documentary Discourse'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'MadsM' AND c.name = 'Drama Enthusiasts'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'LetoJ' AND c.name = 'Drama Enthusiasts'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'KKapoor' AND c.name = 'Drama Enthusiasts'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'DeadRyan' AND c.name = 'Drama Enthusiasts'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'JessC' AND c.name = 'Eco Innovators'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'AquaJay' AND c.name = 'Electric Drive'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'JLaw' AND c.name = 'Electric Drive'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'KenGos' AND c.name = 'Electric Drive'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'KKaif' AND c.name = 'Electric Drive'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'NFakhri' AND c.name = 'Electronic Beats Society'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'NSchnapp' AND c.name = 'Electronic Beats Society'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'NSid' AND c.name = 'Embroidery Enthusiasts'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'LeoKing' AND c.name = 'English Conversation Circle'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'RRao' AND c.name = 'English Conversation Circle'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'AVik' AND c.name = 'English Conversation Circle'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'KKaif' AND c.name = 'English Conversation Circle'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'ThorChris' AND c.name = 'English Conversation Circle'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'TPannu' AND c.name = 'English Conversation Circle'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'PotterDan' AND c.name = 'English Conversation Circle'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'JessC' AND c.name = 'English Conversation Circle'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'RonGrint' AND c.name = 'English Conversation Circle'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'NeoReeves' AND c.name = 'Environmental Science Society'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'ZQueen' AND c.name = 'Environmental Science Society'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'AVik' AND c.name = 'Environmental Science Society'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'BourneMatt' AND c.name = 'Environmental Science Society'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'ACurtis' AND c.name = 'Environmental Science Society'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'ThorChris' AND c.name = 'Esports Elite'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'AnneH' AND c.name = 'Esports Elite'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'LetoJ' AND c.name = 'Esports Elite'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'MavCruise' AND c.name = 'Esports Elite'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'ARai' AND c.name = 'Esports Elite'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'AKapoor' AND c.name = 'Esports Elite'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'MDixit' AND c.name = 'Esports Elite'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'RKapo' AND c.name = 'Esports Elite'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'SRKhan' AND c.name = 'Esports Elite'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'WonderGal' AND c.name = 'Fantasy Fiction Society'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'IronBob' AND c.name = 'Fantasy Realms Reading Club'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'AnneH' AND c.name = 'Fantasy Realms Reading Club'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'Johnny' AND c.name = 'Fantasy Realms Reading Club'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'JLaw' AND c.name = 'Fantasy Realms Reading Club'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'MDixit' AND c.name = 'Fantasy Realms Reading Club'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'DPadu' AND c.name = 'Fantasy Realms Reading Club'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'LetoJ' AND c.name = 'Fantasy Realms Reading Club'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'MadsM' AND c.name = 'Farm-to-Table'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'KKapoor' AND c.name = 'Farm-to-Table'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'KenGos' AND c.name = 'Farm-to-Table'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'BDHoward' AND c.name = 'Farm-to-Table'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'ZQueen' AND c.name = 'Farm-to-Table'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'ARai' AND c.name = 'Farm-to-Table'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'KSanon' AND c.name = 'Fitness for Life'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'SKapoor' AND c.name = 'Fitness for Life'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'HarleyMarg' AND c.name = 'Fitness for Life'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'MavCruise' AND c.name = 'Fitness for Life'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'ZQueen' AND c.name = 'Flower Fanatics'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'MavCruise' AND c.name = 'Flower Fanatics'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'DuneTim' AND c.name = 'French & Beyond'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'CillMurph' AND c.name = 'French & Beyond'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'BDHoward' AND c.name = 'Gaming & Development'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'BourneMatt' AND c.name = 'Gaming & Development'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'SpideyTom' AND c.name = 'Gastronomy Gurus'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'AVik' AND c.name = 'Gastronomy Gurus'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'TheRock' AND c.name = 'Gastronomy Gurus'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'AmyA' AND c.name = 'Grandmasters Circle'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'Zefron' AND c.name = 'Grandmasters Circle'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'JBardem' AND c.name = 'Green Earth Movement'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'JAbraham' AND c.name = 'Green Earth Movement'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'Tabz' AND c.name = 'Green Earth Movement'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'KKaif' AND c.name = 'Green Thumbs Collective'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'Tabz' AND c.name = 'Herb Lovers Society'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'LeoKing' AND c.name = 'Herb Lovers Society'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'KenGos' AND c.name = 'Herb Lovers Society'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'AVik' AND c.name = 'Herb Lovers Society'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'DeadRyan' AND c.name = 'Herb Lovers Society'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'FAkhtar' AND c.name = 'Herb Lovers Society'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'PCruz' AND c.name = 'Herb Lovers Society'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'QuietEmily' AND c.name = 'Herb Lovers Society'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'NateD' AND c.name = 'Herb Lovers Society'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'FAkhtar' AND c.name = 'HIIT Warriors'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'DeadRyan' AND c.name = 'HIIT Warriors'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'ZQueen' AND c.name = 'HIIT Warriors'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'SpideyTom' AND c.name = 'HIIT Warriors'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'KalDan' AND c.name = 'HIIT Warriors'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'IronBob' AND c.name = 'HIIT Warriors'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'PCruz' AND c.name = 'HIIT Warriors'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'AVik' AND c.name = 'HIIT Warriors'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'CWaltz' AND c.name = 'Hip Hop Hustle'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'DuneTim' AND c.name = 'Hip Hop Hustle'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'KSanon' AND c.name = 'Historical Fiction Guild'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'MBBMillie' AND c.name = 'Historical Fiction Guild'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'MDixit' AND c.name = 'Historical Fiction Guild'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'WandaLiz' AND c.name = 'Historical Fiction Guild'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'MBJordan' AND c.name = 'Historical Fiction Guild'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'HarleyMarg' AND c.name = 'Improv Acting Troupe'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'PChops' AND c.name = 'Improv Acting Troupe'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'CWaltz' AND c.name = 'Improv Acting Troupe'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'AVik' AND c.name = 'Improv Acting Troupe'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'JBardem' AND c.name = 'Improv Acting Troupe'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'LSeydoux' AND c.name = 'Improv Acting Troupe'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'VHud' AND c.name = 'Improv Acting Troupe'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'AquaJay' AND c.name = 'Improv Acting Troupe'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'ZQueen' AND c.name = 'Improv Acting Troupe'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'LetoJ' AND c.name = 'Indie Film Society'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'CWaltz' AND c.name = 'Indie Film Society'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'SRKhan' AND c.name = 'Indie Film Society'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'ABhatt' AND c.name = 'Indie Film Society'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'NSid' AND c.name = 'Indie Film Society'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'NSchnapp' AND c.name = 'Indie Film Society'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'Zefron' AND c.name = 'Indie Film Society'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'AmyA' AND c.name = 'International Flavors'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'AKhurrana' AND c.name = 'International Flavors'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'PascalP' AND c.name = 'Jazz Jams'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'TheRock' AND c.name = 'Jazz Jams'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'LSeydoux' AND c.name = 'Jazz Jams'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'HarleyMarg' AND c.name = 'Journalism and Media Club'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'SMalhotra' AND c.name = 'Journalism and Media Club'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'CWaltz' AND c.name = 'Journalism and Media Club'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'EGreen' AND c.name = 'Journalism and Media Club'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'FinnW' AND c.name = 'Judo Champions'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'SMarceau' AND c.name = 'Judo Champions'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'TitanKate' AND c.name = 'Judo Champions'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'JAbraham' AND c.name = 'Judo Champions'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'HarleyMarg' AND c.name = 'Judo Champions'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'JBardem' AND c.name = 'Judo Champions'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'LetoJ' AND c.name = 'Junior Robotics League'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'TPannu' AND c.name = 'Junior Robotics League'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'NPort' AND c.name = 'Junior Robotics League'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'DPadu' AND c.name = 'Junior Robotics League'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'AKhurrana' AND c.name = 'Junior Robotics League'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'NeoReeves' AND c.name = 'Junior Robotics League'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'NFakhri' AND c.name = 'Karate Kids'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'MavCruise' AND c.name = 'Karate Kids'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'RKapo' AND c.name = 'Karate Kids'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'KenGos' AND c.name = 'Karate Kids'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'HarleyMarg' AND c.name = 'Karate Kids'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'PCruz' AND c.name = 'Knitting Circle'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'WonderGal' AND c.name = 'Knitting Circle'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'NSchnapp' AND c.name = 'Kung Fu Warriors'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'MavCruise' AND c.name = 'Kung Fu Warriors'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'JOrtega' AND c.name = 'Kung Fu Warriors'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'LSeydoux' AND c.name = 'Legacy League'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'AmyA' AND c.name = 'Legacy League'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'AnneH' AND c.name = 'Legacy League'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'TPannu' AND c.name = 'Legacy League'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'IronBob' AND c.name = 'Legacy League'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'LetoJ' AND c.name = 'Lens & Light'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'PChopra' AND c.name = 'Lens & Light'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'HRoshan' AND c.name = 'Lens & Light'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'DSalmaan' AND c.name = 'Lens & Light'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'SaiRon' AND c.name = 'Lens & Light'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'JOrtega' AND c.name = 'Lens & Light'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'WonderGal' AND c.name = 'Lens & Light'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'IKhan' AND c.name = 'Lunar Legends'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'HRoshan' AND c.name = 'Lunar Legends'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'TPannu' AND c.name = 'Lunar Legends'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'IronBob' AND c.name = 'Lunar Legends'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'MBajpayee' AND c.name = 'Lunar Legends'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'VHud' AND c.name = 'Lunar Legends'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'VDhawan' AND c.name = 'Lunar Legends'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'RApte' AND c.name = 'Meal Prep Mastery'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'HermiWat' AND c.name = 'Meal Prep Mastery'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'VDhawan' AND c.name = 'Meeples & Dice'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'NeoReeves' AND c.name = 'Meeples & Dice'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'ASharma' AND c.name = 'Meeples & Dice'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'RonGrint' AND c.name = 'Motor Head Racing'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'SKapoor' AND c.name = 'Mountain Mavericks'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'ARai' AND c.name = 'Mountain Mavericks'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'JGL' AND c.name = 'Mountain Mavericks'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'NPort' AND c.name = 'Mountain Mavericks'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'RDeshmukh' AND c.name = 'Mountain Mavericks'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'FloP' AND c.name = 'Mountain Mavericks'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'JessC' AND c.name = 'Mountain Mavericks'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'PChops' AND c.name = 'Mountain Mavericks'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'VHud' AND c.name = 'Mystery Book Circle'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'HarleyMarg' AND c.name = 'Mystery Book Circle'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'JOrtega' AND c.name = 'Mystery Book Circle'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'MBBMillie' AND c.name = 'Mystery Book Circle'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'NSchnapp' AND c.name = 'Mystery Book Circle'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'NPort' AND c.name = 'Mystery Book Circle'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'VDhawan' AND c.name = 'Mystery Book Circle'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'PChops' AND c.name = 'Nature Photography Society'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'NeoReeves' AND c.name = 'Nature Photography Society'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'VBalan' AND c.name = 'Nature Photography Society'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'LSeydoux' AND c.name = 'Nature Photography Society'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'RKapo' AND c.name = 'Nature Photography Society'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'JOrtega' AND c.name = 'Nature Walkers'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'AntPaul' AND c.name = 'Nature Walkers'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'PChops' AND c.name = 'Nature Walkers'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'ABhatt' AND c.name = 'Nature Walkers'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'BourneMatt' AND c.name = 'Nature Walkers'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'BDHoward' AND c.name = 'Otaku Society'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'PTripathi' AND c.name = 'Otaku Society'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'JGL' AND c.name = 'Otaku Society'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'PCruz' AND c.name = 'Otaku Society'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'PascalP' AND c.name = 'Otaku Society'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'MBJordan' AND c.name = 'Otaku Society'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'LSeydoux' AND c.name = 'Page Turners'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'WolverineHugh' AND c.name = 'Page Turners'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'SAKhan' AND c.name = 'Page Turners'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'MBJordan' AND c.name = 'Page Turners'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'AKapoor' AND c.name = 'Page Turners'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'VBalan' AND c.name = 'Page Turners'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'PTripathi' AND c.name = 'Page Turners'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'KSanon' AND c.name = 'Page Turners'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'JessC' AND c.name = 'Philosophical Arguments'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'DeadRyan' AND c.name = 'Philosophical Arguments'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'CillMurph' AND c.name = 'Photo Editing Wizards'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'ScarJo' AND c.name = 'Photo Editing Wizards'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'WolverineHugh' AND c.name = 'Photo Editing Wizards'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'SMalhotra' AND c.name = 'Photo Editing Wizards'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'AVik' AND c.name = 'Photo Editing Wizards'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'Johnny' AND c.name = 'Photo Editing Wizards'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'PotterDan' AND c.name = 'Photo Editing Wizards'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'MBajpayee' AND c.name = 'Physics Enthusiasts'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'LeoKing' AND c.name = 'Physics Enthusiasts'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'FAkhtar' AND c.name = 'Physics Enthusiasts'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'JAbraham' AND c.name = 'Physics Enthusiasts'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'SRKhan' AND c.name = 'Physics Enthusiasts'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'SMalhotra' AND c.name = 'Physics Enthusiasts'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'SAKhan' AND c.name = 'Physics Enthusiasts'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'RApte' AND c.name = 'Physics Enthusiasts'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'WolverineHugh' AND c.name = 'Physics Enthusiasts'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'PChops' AND c.name = 'Planet Hunters'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'Tabz' AND c.name = 'Planet Hunters'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'KalDan' AND c.name = 'Planet Hunters'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'OSy' AND c.name = 'Planet Hunters'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'HermiWat' AND c.name = 'Planet Hunters'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'HRoshan' AND c.name = 'Poetry Society'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'EmStoner' AND c.name = 'Poetry Society'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'AntPaul' AND c.name = 'Poetry Society'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'BourneMatt' AND c.name = 'Poetry Society'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'RDeshmukh' AND c.name = 'Poetry Society'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'DuneTim' AND c.name = 'Poetry Society'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'PChops' AND c.name = 'Poetry Society'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'SAKhan' AND c.name = 'Political Roundtable'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'VHud' AND c.name = 'Political Roundtable'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'RonGrint' AND c.name = 'Polyglot Society'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'MBBMillie' AND c.name = 'Polyglot Society'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'SAKhan' AND c.name = 'Polyglot Society'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'JLaw' AND c.name = 'Portrait Perfection'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'SaiRon' AND c.name = 'Recycling Rangers'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'JBardem' AND c.name = 'Recycling Rangers'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'PCruz' AND c.name = 'Recycling Rangers'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'DSalmaan' AND c.name = 'Recycling Rangers'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'LetoJ' AND c.name = 'Recycling Rangers'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'DeadRyan' AND c.name = 'Retro Game Vault'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'ACurtis' AND c.name = 'Retro Game Vault'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'WolverineHugh' AND c.name = 'Retro Game Vault'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'ScarJo' AND c.name = 'Rhetoric Revolution'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'FAkhtar' AND c.name = 'Rhetoric Revolution'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'NSid' AND c.name = 'Rhetoric Revolution'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'HermiWat' AND c.name = 'Rhythmic Revolution'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'DSalmaan' AND c.name = 'Rhythmic Revolution'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'CapEvans' AND c.name = 'Robo Revolution'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'NSid' AND c.name = 'Robo Revolution'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'JessC' AND c.name = 'Robo Revolution'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'DuneTim' AND c.name = 'Robo Revolution'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'HRoshan' AND c.name = 'Robo Revolution'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'PChops' AND c.name = 'Robo Revolution'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'DSalmaan' AND c.name = 'RoboMasters'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'AnneH' AND c.name = 'RoboMasters'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'ASharma' AND c.name = 'Rock and Roll Revival'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'SMarceau' AND c.name = 'Scientific Explorers'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'BDHoward' AND c.name = 'Scientific Explorers'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'JOrtega' AND c.name = 'Scientific Explorers'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'SMalhotra' AND c.name = 'Scientific Explorers'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'QuietEmily' AND c.name = 'Scientific Explorers'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'KKaif' AND c.name = 'Scientific Explorers'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'SRKhan' AND c.name = 'Scientific Explorers'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'AVik' AND c.name = 'Script Writers Guild'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'EGreen' AND c.name = 'Script Writers Guild'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'AKapoor' AND c.name = 'Script Writers Guild'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'CWaltz' AND c.name = 'Shakespeare Society'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'BDHoward' AND c.name = 'Shakespeare Society'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'SRKhan' AND c.name = 'Shakespeare Society'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'EmStoner' AND c.name = 'Shakespeare Society'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'HRoshan' AND c.name = 'Shakespeare Society'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'WandaLiz' AND c.name = 'Shonen Showdown'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'AmyA' AND c.name = 'Shonen Showdown'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'KKapoor' AND c.name = 'Shonen Showdown'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'NSchnapp' AND c.name = 'Shonen Showdown'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'AquaJay' AND c.name = 'Shonen Showdown'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'DSalmaan' AND c.name = 'Shonen Showdown'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'LSeydoux' AND c.name = 'Shonen Showdown'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'OSy' AND c.name = 'Shonen Showdown'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'HarleyMarg' AND c.name = 'Shutterbugs'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'ACurtis' AND c.name = 'Shutterbugs'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'SKapoor' AND c.name = 'Shutterbugs'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'HermiWat' AND c.name = 'Shutterbugs'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'Johnny' AND c.name = 'Silent Reading Social'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'HarleyMarg' AND c.name = 'Silent Reading Social'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'RKapo' AND c.name = 'Sketch & Sip Society'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'DSalmaan' AND c.name = 'Sketch & Sip Society'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'PTripathi' AND c.name = 'Sketch & Sip Society'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'NeoReeves' AND c.name = 'Sketch & Sip Society'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'LeoKing' AND c.name = 'Sketch & Sip Society'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'AnneH' AND c.name = 'Sketch & Sip Society'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'CillMurph' AND c.name = 'Sketch & Sip Society'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'KenGos' AND c.name = 'Sketch & Sip Society'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'MBJordan' AND c.name = 'Sketch & Sip Society'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'KKaif' AND c.name = 'Solar Power Pioneers'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'MBJordan' AND c.name = 'Solar Power Pioneers'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'HermiWat' AND c.name = 'Solar Power Pioneers'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'MDixit' AND c.name = 'Spanish Speakers Unite'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'RKapo' AND c.name = 'Spanish Speakers Unite'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'IronBob' AND c.name = 'Spanish Speakers Unite'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'PTripathi' AND c.name = 'Spanish Speakers Unite'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'FloP' AND c.name = 'Spanish Speakers Unite'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'MavCruise' AND c.name = 'Speed Chess Society'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'RApte' AND c.name = 'Speed Chess Society'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'PChopra' AND c.name = 'Speed Chess Society'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'RRao' AND c.name = 'Speed Chess Society'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'AnneH' AND c.name = 'Stage Stars'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'ZQueen' AND c.name = 'Stargazers United'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'AntPaul' AND c.name = 'Street Art Underground'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'KKaif' AND c.name = 'Street Art Underground'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'DeadRyan' AND c.name = 'Street Art Underground'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'RApte' AND c.name = 'Strength and Conditioning'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'NSchnapp' AND c.name = 'Strength and Conditioning'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'BDHoward' AND c.name = 'Strength and Conditioning'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'BatBale' AND c.name = 'Strength and Conditioning'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'HermiWat' AND c.name = 'Strength and Conditioning'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'JGL' AND c.name = 'Studio Ghibli Nights'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'JBardem' AND c.name = 'Studio Ghibli Nights'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'CWaltz' AND c.name = 'Studio Ghibli Nights'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'KSanon' AND c.name = 'Sustainable Gardens'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'PotterDan' AND c.name = 'Sustainable Gardens'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'SpideyTom' AND c.name = 'Sustainable Gardens'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'MDixit' AND c.name = 'Sustainable Gardens'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'LeoKing' AND c.name = 'Sustainable Gardens'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'MDixit' AND c.name = 'Tabletop Tavern'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'RKapo' AND c.name = 'Tabletop Tavern'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'ARai' AND c.name = 'Tabletop Tavern'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'NFakhri' AND c.name = 'Tabletop Tavern'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'Johnny' AND c.name = 'Tabletop Titans'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'DPadu' AND c.name = 'Tabletop Titans'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'VDhawan' AND c.name = 'Tabletop Titans'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'Zefron' AND c.name = 'Tabletop Titans'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'RonGrint' AND c.name = 'Tabletop Titans'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'IronBob' AND c.name = 'Tabletop Titans'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'AVik' AND c.name = 'Tabletop Titans'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'KalDan' AND c.name = 'Tabletop Titans'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'SKapoor' AND c.name = 'Tabletop Titans'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'QuietEmily' AND c.name = 'Taekwondo Tigers'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'OSy' AND c.name = 'Taekwondo Tigers'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'KenGos' AND c.name = 'Taekwondo Tigers'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'AntPaul' AND c.name = 'Taekwondo Tigers'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'RRao' AND c.name = 'Taekwondo Tigers'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'PascalP' AND c.name = 'Taekwondo Tigers'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'ThorChris' AND c.name = 'Taekwondo Tigers'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'EmStoner' AND c.name = 'Taekwondo Tigers'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'CWaltz' AND c.name = 'Taekwondo Tigers'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'AmyA' AND c.name = 'Tech Innovators'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'HRoshan' AND c.name = 'Tech Innovators'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'PTripathi' AND c.name = 'Tech Innovators'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'NSid' AND c.name = 'TechBot Society'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'Tabz' AND c.name = 'The Creative Palette'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'LSeydoux' AND c.name = 'The Creative Palette'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'RDeshmukh' AND c.name = 'The Creative Palette'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'AntPaul' AND c.name = 'The Creative Palette'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'WolverineHugh' AND c.name = 'The Creative Palette'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'DeadRyan' AND c.name = 'The Creative Palette'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'AnneH' AND c.name = 'The Game Masters'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'JOrtega' AND c.name = 'The Game Masters'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'SMarceau' AND c.name = 'The Game Masters'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'SAKhan' AND c.name = 'The Game Masters'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'DuneTim' AND c.name = 'The Game Masters'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'DBruehl' AND c.name = 'The Logical Argument'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'Johnny' AND c.name = 'The Pit Stop'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'WinR' AND c.name = 'The Pit Stop'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'LetoJ' AND c.name = 'The Pit Stop'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'SRKhan' AND c.name = 'The Rook and Pawn'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'MDixit' AND c.name = 'The Rook and Pawn'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'JAbraham' AND c.name = 'The Rook and Pawn'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'DPadu' AND c.name = 'The Rook and Pawn'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'NSchnapp' AND c.name = 'The Rook and Pawn'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'BourneMatt' AND c.name = 'The Rook and Pawn'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'AquaJay' AND c.name = 'The Rook and Pawn'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'RApte' AND c.name = 'The Rook and Pawn'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'MavCruise' AND c.name = 'The Sound Collective'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'IKhan' AND c.name = 'The Sound Collective'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'ScarJo' AND c.name = 'The Sound Collective'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'SpideyTom' AND c.name = 'The Sound Collective'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'AmyA' AND c.name = 'Theater Arts Society'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'SMarceau' AND c.name = 'Theater Arts Society'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'MavCruise' AND c.name = 'Trail Blazers'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'KKapoor' AND c.name = 'Trail Blazers'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'PCruz' AND c.name = 'Trail Blazers'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'PascalP' AND c.name = 'Trail Blazers'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'VHud' AND c.name = 'Trail Blazers'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'IronBob' AND c.name = 'Trail Blazers'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'MadsM' AND c.name = 'Trail Blazers'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'PotterDan' AND c.name = 'Upcycled Artworks'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'BourneMatt' AND c.name = 'Upcycled Artworks'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'IKhan' AND c.name = 'Upcycled Artworks'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'LetoJ' AND c.name = 'Upcycled Artworks'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'NeoReeves' AND c.name = 'Upcycled Artworks'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'NateD' AND c.name = 'Upcycled Artworks'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'FAkhtar' AND c.name = 'Urban Growers'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'AKhurrana' AND c.name = 'Vintage Vibes'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'HermiWat' AND c.name = 'Vintage Vibes'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'ARai' AND c.name = 'Vintage Vibes'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'AVik' AND c.name = 'Vintage Vibes'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'MBajpayee' AND c.name = 'Vintage Vibes'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'RApte' AND c.name = 'Vintage Vibes'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'WinR' AND c.name = 'Watercolor Wonders'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'EGreen' AND c.name = 'Weekend Wanderers'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'EmStoner' AND c.name = 'Weekend Wanderers'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'MDixit' AND c.name = 'Yoga and Flexibility'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'ASharma' AND c.name = 'Yoga and Flexibility'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'PascalP' AND c.name = 'Yoga and Flexibility'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'DuneTim' AND c.name = 'Yoga and Flexibility'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'ABhatt' AND c.name = 'Yoga and Flexibility'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'WandaLiz' AND c.name = 'Yoga and Flexibility'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'PChops' AND c.name = 'Zero Waste Warriors'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'DPadu' AND c.name = 'Zero Waste Warriors'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'NSid' AND c.name = 'Zero Waste Warriors'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'IronBob' AND c.name = 'Zero Waste Warriors'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'NSchnapp' AND c.name = 'Zero Waste Warriors'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'ARai' AND c.name = 'Zumba Party'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'SRKhan' AND c.name = 'Zumba Party'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'Johnny' AND c.name = 'Zumba Party'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'VDhawan' AND c.name = 'Zumba Party'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'CaptainBrie' AND c.name = 'Zumba Party'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'PascalP' AND c.name = 'Zumba Party'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'ThorChris' AND c.name = 'Zumba Party'; 
INSERT INTO userclubs (account_id, club_id, active) SELECT a.account_id, c.club_id, 'A' FROM accounts a, clubs c WHERE a.nick_name = 'JGL' AND c.name = 'Zumba Party'; 
commit;

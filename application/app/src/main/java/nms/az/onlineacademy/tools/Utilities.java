package nms.az.onlineacademy.tools;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatDialog;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import nms.az.onlineacademy.R;
import nms.az.onlineacademy.models.Category;
import nms.az.onlineacademy.models.Chapter;
import nms.az.onlineacademy.models.Course;
import nms.az.onlineacademy.models.Slide;

/**
 * Created by anar on 7/29/15.
 */
public class Utilities {


    public static final int ACTION_SHOW_MESSAGE = 0;
    public static final int ACTION_INPUT = 1;

    public static void showDialog(Context context, Integer... args) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context, R.style.CustomDialog);
        builder.setTitle(args[0]);
        builder.setMessage(args[1]);
        builder.setPositiveButton(args[2], null);

        if (args.length == 4) {
            builder.setNegativeButton(args[3], null);
        }

        builder.show();
    }

    /*
    * Below methods is written for testing purposes. Once the application is ready
    * these methods will be removed or comment out in order to avoid extra memory space.
    * */


   public static List<Course> getCourses(Context context, int catId) {
        List<Course> courses = new LinkedList<>();


        List<Slide> body_slides = new LinkedList<>();

        body_slides.add(new Slide("What What does your body do to let you know something isn't right?", "Whatever " +
                "Most people are completely unaware of how much better they'd feel if they changed a few simple things in their diet." +
                " It can improve your energy levels, mood, fitness and the way " +
                "you think and feel. Your body almost always gives you cues and clues. It is up to you whether you decide to ignore them."));
        body_slides.add(new Slide("What affects how you age the most?", "Genetics only affect your ageing by 20%. The rest is determined by the environment and our lifestyle. Once you reach your twenties or thirties, you will begin to age, and without proper nutrition you will feel tired and lethargic. By the time you are 50, your lifestyle will indicate how you age."));
        body_slides.add(new Slide("Where on your body does excess fat really put your health at risk?", "Having excess fat to lose is harmful for your body, but having weight to lose mainly arround the waist puts you at a very high risk of developing health conditions. The Heart Foundation recommends that men's waists should measure less than 94 cm (37 inches) and for women it's under 80 cm (31.5 inches)."));
        body_slides.add(new Slide("How many people will develop diabetes in their life?", "1 in 3 people develop Type 2 Diabetes. Poor eating habits, high stress levels and inactivity are some of its causes. Some people predisposed to it, but the trigger is always environment and lifestyle habits. People who eat greens reduce their risk of developing diabetes by 14%."));
        body_slides.add(new Slide("What kind of food is detrimental to your heart health?", "Processed food is one of the worst culprits of heart disease whereas egg yolks are natural and will not increase your cholesterol levels. Also, peanuts are loaded with good fats, which are heart healthy. Try to eat as much fresh fruit and vegetables as possible and avoid processed foods."));
        body_slides.add(new Slide("What is the healthy range for total cholesterol in your blood?", "The ideal level of total cholesterol is 180 mg⁄dl. Above 200 mg⁄dl puts your heart and your body in a dangerous zone. A healthy fasting sufar level is an important health parameter. If it is beyond 120 mg⁄dl, you are considered a diabetic. If it is above mg⁄dl, it means you could be pre– diabetic."));
        body_slides.add(new Slide("What is the scientific name for good cholesterol?", "HDL is a good cholesterol. One great way of increasing this is by exercising regularly and eating a handful of unsalted nuts daily. LDL is bad cholesterol, and high levels can be very harmful to your heart health. Triglyceride levels should always be under control for a better functioning heart."));

        Chapter you_and_body = new Chapter("You and Your Body",  body_slides);


        List<Slide> food_slides = new LinkedList<>();

        food_slides.add(new Slide("What has evolved over thousands of years?", "In the span of 10000 years, people's diets and lifestyles have changed beyond all recognition. Even 200 years ago, humans consumed a very different diet and led a more active lifestyle. Plain food diets meant many of the problems of today like diabetes, obesity and heart disease were uncommon."));
        food_slides.add(new Slide("Who enjoyed a simple diet, rich in fibre and low in fat?", "Ten thousand years ago, primitive man's life was incredibly active. He spent his days roaming large areas searching for nuts, berries and animals he could hunt. This way of living provided a simple diet of diverse proteins and carbohydrates with a positive low glycemic index and loads of fibre."));
        food_slides.add(new Slide("What food source fed the city people of the Middle Ages?", "During the Middle Ages (from the mid– 10th century onwards), the number of small farms had reduced as people flocked to the growing cities. In a bid to keep urban populations fed, farms supplied the cities with food they knew would be the easiest to store and transport; grains became a staple."));
        food_slides.add(new Slide("What How did people's health suffer during the industrial revolution?", "As cities kept expanding throughout the 19th century, industrial cereal was needed to feed the growing masses. However, growing huge amounts of cereals reduced the amount of land available for rearing animals and growing vegetables and fruits. As a result, people became deficient in protein."));
        food_slides.add(new Slide("What is the majority of today's food produced?", "The food of our modern times is characterized entirely by mechanization. Today, farms are vast and farm laborers have been replaced by machines. Fresh products are often expensive, so the majority of the population eat mass– produced, heavily processed foods packed with chemicals and preservatives."));
        food_slides.add(new Slide("What will dictate our future diet as the world's population grows?", ""));
        food_slides.add(new Slide("", "It is concerning that in the future, science will dictate our diet. Genetically modified crops are designed to resist pests and grow to large sizes, \"meat\"– type proteins are grown in labs while animals are fed medications to produce more milk and develop more muscle."));

        Chapter food_chapter = new Chapter("Food: Past, Present and Future",  food_slides);


        List<Slide> carbo_slides = new LinkedList<>();

        carbo_slides.add(new Slide("What happens if you consume more carbs than your body needs?", "If you consume more carbohydrates than your body needs, it gets stored as glycogen in your liver and muscles. The excess gets stored as fat. How healthy different carbs are for your body depends on the different nutrients each one provides, plus the effect it has on your blood glucose levels."));
        carbo_slides.add(new Slide("What How many macro– nutrients is our diet made up of?", "Your diet is composed of three major macro– nutrients – protein, fat and carbohydrates. The most basic unit of carbohydrate is simple sugar or glucose. When you eat any kind of carbohydrates, it enters your blood stream and is then broken down into glucose for instant digestion and absorption."));
        carbo_slides.add(new Slide("What percentage of your diet should be made up of carbs?", "Carbohydrates should ideally make up around 55% of your daily diet. Your body's preferred source of energy, carbohydrates are released quickly in the form of glucose. The brain generally needs about 150 grams of carbohydrates to function normally. However, this fluctuates from person to person."));
        carbo_slides.add(new Slide("What makes a carbohydrate complex?", "The complex chemical structure of carbohydrates slows down the release of glucose in our bloodstream. Complex carbohydrates are starches found in cereal grains, seeds and roots. Composed of complex structures, unlike simple carbohydrates, they don't cause a sudden spike in blood glucose levels."));
        carbo_slides.add(new Slide("What are slow– digesting carbs full of?", "The high fibre and nutrient content in slow digesting carbohydrates fill you up quickly and also reduce your appetite naturally. Wild rice, quinoa, rye bread, amaranth, sweet potatoes, beans and lentils, vegetables, whole fruit and avocados are all good, slow– digesting carbohydrates."));
        carbo_slides.add(new Slide("What type of food reduces hunger cravings?", "Rough and indigestible, fibre is an essential part of your diet. It helps slow down the absorption of glucose into the bloodstream and reduces the likelihood of spiking blood sugar levels. Some great, natural sources of fibre include garden vegetables, pulses and wholegrain and whole meal breads."));
        carbo_slides.add(new Slide("What What type of food is the leading cause of obesity and diabetes?", "White and brown sugar, fresh and packaged fruit juices, honey, high fructose corn syrup, sweet processed foods, white bread and white pasta are all fast– digesting carbs. Fast– digesting carbs are the leading cause of diabetes, high blood pressure, PCOS and increased body fat percentage."));
        carbo_slides.add(new Slide("How many grams of carbohydrates do you need per day", "How much you need depends on your activity levels, your fitness goals and your health concerns 150 grams per day could be too much or too little for some people. It depends a lot on your current lifestyle. However, 250 grams is generally seen as the minimum amount people need in a regular diet."));
        carbo_slides.add(new Slide("What kind of sugar do sweets and cakes contain?", "Simple carbohydrates are made from only one or two sugar units. These simple sugars include: fructose, galactose, maltose and lactose. They're found in fruits, vegetables and milk. Refined sugars like sucrose are found in table sugar and processed food products like sweets, chocolates and cakes."));
        carbo_slides.add(new Slide("Why does your body become \"insulin resistant\"?", "Fast– digesting carbs arrive in the bloodstream quickly, causing a sudden glucose spike. The body respond by secreting insulin through the pancreas to allow glucose to be transported directly to the cells. More glucose means more insulin. Over time, your body can become \"insulin resistant\"."));

        Chapter carbo_chapter = new Chapter("Carbohydrates",carbo_slides);


        List<Slide> proteins_slides = new LinkedList<>();

        proteins_slides.add(new Slide("What is the major function of protein in your body?", "Growing and repairing your body's muscles is one of the most important functions of protein. Unbelievably, every organ in your body is constantly renewing and repairing itself. For this process to work, you need a continual supply of good quality protein. This is why athletes need a lot of protein."));
        proteins_slides.add(new Slide("What What are proteins made of?", "Protein is made up of numerous building blocks called amino acids. Your body requires two types of amino acids: Essential amino acids: your body cannot make these itself and requires adequate amounts in your daily diet; Non– essential amino acids: these amino acids can be made by the body itself."));
        proteins_slides.add(new Slide("What are the 2 types of proteins in food?", "Based on the type of amino acids, proteins are divided into complete and incomplete proteins. Incomplete proteins lack one or more essential amino acids, and are found in legumes and pulses, plus a small amount are found in vegetables and cereals. 1 gram of protein provides approximately 4 calories."));
        proteins_slides.add(new Slide("Why do we need to ensure a daily supply of protein?", "Protein is part of every cell of your body. Your skin, hair and nails are all composed of the protein keratin. This is why you need a constant protein supply. Your body stores excess fat and glucose, but it can't store protein. For this reason, making sure get sufficient protein is essential."));
        proteins_slides.add(new Slide("Where do complete proteins come from?", "Complete proteins are obtained from animal products. They contain all the essential amino acids to promote growth, repair and metabolic healing. They include: eggs, red meat, fish, chicken, beef, yoghurt, milk and cheese."));
        proteins_slides.add(new Slide("What time in your life will you need the most protein?", "Middle– aged and older people actually need more protein than young people. This is further compounded by a 50% drop in hydrochloric acid – what breaks down protein in our stomachs. Dietary protein is essential for every metabolic process in your body; 10– 35% of your daily diet should be protein."));
        proteins_slides.add(new Slide("How can too much protein be bad?", "Too much protein can cause kidney and liver problems, plus the associated saturated fat can enhance the risk of heart disease. Clean and unprocessed sources of protein are always best. Fresh tofu, plain soy milk and steamed edamame beans are great 2– 3 times a week. Tempeh is best of the lot."));
        proteins_slides.add(new Slide("Why do you need more protein after an intense workout?", "You lose protein from your muscles while you work out. Post– workout protein will help muscles recover, which will give you higher energy levels. Having a high– protein meal after working out will help replenish muscles. Also, proteins require a longer time for digestion; you feel fuller for longer."));
        proteins_slides.add(new Slide("How much protein does a moderately active person need?", "Adequate amounts of dietary protein helps you build muscle mass, which improves the fat– to– muscle– ratio in your body, making you feel fitter, stronger and hormonally healthy. If you're active, you need to consume 1.2– 1.5 g per kg of body weight. The more athletic you are, the more you will need."));

        Chapter protein_chapter = new Chapter("Proteins", proteins_slides);


        List<Chapter> nutrition_chapters = new LinkedList<>();
        nutrition_chapters.add(you_and_body);
        nutrition_chapters.add(food_chapter);
        nutrition_chapters.add(carbo_chapter);
        nutrition_chapters.add(protein_chapter);

        Course nutrition = new Course(1, 0, "Essential Nutrition", nutrition_chapters, 12456, R.drawable.course_img_essential_nutrition);

        courses.add(nutrition);


        //---------------------------------------------------------------------

        List<Slide> confidience_slides = new LinkedList<>();

        confidience_slides.add(new Slide("What is the main benefit of confidence?","When you are confident, you are willing to try new things without the fair of failure. A confident person accepts that they have weaknesses and is eager to learn from them. People like the company of confident person, they are interested in their opinions and enjoy spending time with them. Benefits A confident person knows that they don't need to win every time – whether it be a sports activity, a debate with colleagues or in a romantic way but they know they'll gain nothing if they don't try. More benefits of confidence: – You'll perform better in all aspects of your life; – You'll be happier; – You'll improve your social skills; – You'll be healthier."));
        confidience_slides.add(new Slide("What is confidence?","Confidence is having faith in your chosen course of action, no matter how tough the situation seems. It is trusting yourself and believing that your choices will work out well because you have made those decisions yourself."));
        confidience_slides.add(new Slide("What effect does confidence have on others?","When someone is confident, they have the self– assurance to speak up. As a result, other people will often turn to this person for their opinion, their advice and their view on certain things. This is because people are naturally drawn to those who we believe are more confident than them. Confidence traits Other qualities of confident people: – They consider finding out what is right more important than actually being right; – They are great listeners; – They aren't afraid to ask for help; – They aren't afraid to look foolish or own up to their mistakes; – They don't need glory."));
        confidience_slides.add(new Slide("How does someone with confidence behave?","People often confuse confidence with arrogance. However, they are very different. Being a confident person does not mean that you are rude, insensitive or overbearing. It takes confidence to admit that you don't know the solution to a problem, whereas an arrogant person is unlike to admit this. Signs of arrogance: – Dropping names unnecessarily; – Consistently interrupting conversations; – Putting others down; – Blaming others; – Consistently being late."));
        confidience_slides.add(new Slide("What happens when a person has low levels of confidence?","When you have low levels of confidence, you miss opportunities. These opportunities can take place at work or even in friendships and relationships. Greater self– belief leads people to take risks and try new things, because of their attitude they view every new experience as a positive thing."));
        confidience_slides.add(new Slide("What is low self– esteem?","Imagine you were asked to give a talk about your job at a local school. If you had low self– confidence, you'd be worried about giving the actual presentation, while if you had low self– esteem, you'd be wondering why the school asked you to speak in the first place. To do Make a list: Think about your attributes and personality. Add your strengths, your successes and your achievements in your personal life, education, hobbies and career. Don't forget to include your friends', colleagues' and family's positive opinions and feedback, too. Keep this list somewhere safe and remember to read it regularly for an instant confidence boost, especially when you're feeling particularly down or stressed."));

        Chapter confidience_chapter = new Chapter("Defining Confidence", confidience_slides);

        List<Slide> new_con_slides = new LinkedList<>();

        new_con_slides.add(new Slide("What area of your life does low self– confidence affect most?","People often have a bad sense of their own personal confidence level. You may think you have loads of confidence, yet can't quite work out why you're overlooked in all areas of life: work, social situations and relationships. This is likely because you are not as confident as you think you are. Did you know? Oprah Winfrey was fired from her first TV reporting job because she was deemed \"not suitable for television\". Clint Eastwood was fired from Universal Studios in 1954 because a film executive thought is Adam's apple was too big. Stephen King's first novel, \"Carrie\", was rejected by his publisher 30 times."));
        new_con_slides.add(new Slide("Why is there hope for people with self– doubt?","Confidence isn't something you're born with but something you develop. Every day, you are faced with challenges that can damage your sense of self– worth. However, you are also faced with opportunities to further develop your confidence and eliminate self– doubt. It is not easy, but it is worth it."));
        new_con_slides.add(new Slide("What can people who are confident at work do?","Confident people are comfortable in most situations. This is because they are assured that they are capable, fair– minded and willing to listen. If a confident person wishes to speak up in an awkward situation they do it with ease because they are comfortable with their abilities."));
        new_con_slides.add(new Slide("What is a trait of all confident people?","Confident people are positive. They see the good in others, look for the silver lining in the cloud and know how to turn something negative into a positive. It is their confidence in themselves that makes things seem achievable when others may feel overwhelmed or stressed."));
        new_con_slides.add(new Slide("How can you make a goal more definite?","Make a list of goals that you'd like to achieve, with a realistic timeline of when you'd like to achieve them. You will be surprised at how a simple list can make you feel in control. The act of writing a goal make it feel official and can spur you on to achieve it. Goal setting tips: – Make sure you have defined the goal clearly; – Make sure your goals don't conflict with other goals or your lifestyle; – Break big goals into small, manageable chunks; – Make a list of goals you've achieved in the last 12 months."));
        new_con_slides.add(new Slide("What should you do when you achieve a goal?","When you achieve a goal, acknowledge your accomplishment! It may be as simple as tweeting about it or placing a status update on Facebook. It is a mental reward to yourself and also gives others the opportunity to congratulate you. Other people's admiration is always a confidence boost. Try this: When someone congratulates you, your default reaction may be to say, \"Oh, it was nothing\", But you should accept the praise! It is important in developing your confidence."));
        new_con_slides.add(new Slide("What positive thing comes from failure?","If you fall short the first time, figure out why this is. Perhaps you need more resources or more time to develop your skills. The bottom line is that you need to identify the reasons for your failure and be excited to do better next time."));

        Chapter new_con_chapter = new Chapter("New confidence", new_con_slides);


        List<Slide> all_about_u_slides = new LinkedList<>();

        all_about_u_slides.add(new Slide("What is the first, crucial step to developing self– worth?","Value yourself and recognize your self– worth. This in turn will help you build your own confidence by making you feel worthy and comfortable in your own skin. It will aid you in situations in which you may ordinarily feel intimidated or overshadowed by more confident people."));
        all_about_u_slides.add(new Slide("Why do people often give up the creative pursuit they love?","We are not born with self– doubt – it is learned. Self– doubt is the belief that you are not good enough. Instead of saying, \"I'll never be any good at this\", you should ask yourself, \"What can I do to become a better at this?\" Try not to see failure or other people's beliefs as barriers."));
        all_about_u_slides.add(new Slide("What should you replace \"I can't\" with in order to grow your confidence?","If you have low confidence, it can be difficult to recognize your self– doubts. When you find yourself saying, \"I can't\", try replacing it with, \"I can't do that yet, but I am working on it.\" This turns a negative statement into a positive one and reminds you that you are developing your skills."));
        all_about_u_slides.add(new Slide("What is a trait of all confident people?","Confident people are positive. They see the good in others, look for the silver lining in the cloud and know how to turn something negative into a positive. It is their confidence in themselves that makes things seem achievable when others may feel overwhelmed or stressed."));
        all_about_u_slides.add(new Slide("How can you make a goal more definite?","Make a list of goals that you'd like to achieve, with a realistic timeline of when you'd like to achieve them. You will be surprised at how a simple list can make you feel in control. The act of writing a goal make it feel official and can spur you on to achieve it. Goal setting tips: – Make sure you have defined the goal clearly; – Make sure your goals don't conflict with other goals or your lifestyle; – Break big goals into small, manageable chunks; – Make a list of goals you've achieved in the last 12 months."));
        all_about_u_slides.add(new Slide("What should you do when you achieve a goal?","When you achieve a goal, acknowledge your accomplishment! It may be as simple as tweeting about it or placing a status update on Facebook. It is a mental reward to yourself and also gives others the opportunity to congratulate you. Other people's admiration is always a confidence boost. Try this: When someone congratulates you, your default reaction may be to say, \"Oh, it was nothing\", But you should accept the praise! It is important in developing your confidence."));
        all_about_u_slides.add(new Slide("What positive thing comes from failure?","If you fall short the first time, figure out why this is. Perhaps you need more resources or more time to develop your skills. The bottom line is that you need to identify the reasons for your failure and be excited to do better next time."));


        Chapter all_about_u_chapter = new Chapter("All about you", all_about_u_slides);

        List<Slide> con_at_work_slides = new LinkedList<>();

        con_at_work_slides.add(new Slide("How do you need to be seen at your workplace?","The workplace can be filled with conflict and competition. People often make the mistake of \"keeping their head down and getting on with it\", hopping to keep their jobs in uncertain economic times. However, you really need to be the shining star, rather than the well– behaved figure in the background."));
        con_at_work_slides.add(new Slide("What What is the key to being confident among your colleagues?","Confident people work hard. They know that by putting in the hours they will succeed. By working hard they receive recognition for their work which in turn builds more confidence. The key to being confident among your colleagues is being able to assert your abilities, even in the face of difficulty. Tip Be open and honest about your progress on whatever you are working on. If you are working on particularly difficult project, use phrases like, \"It is challenging,\" or \"I am working towards a solution,\" as opposed to \"I am finding it really hard,\" or \"It is impossible."));
        con_at_work_slides.add(new Slide("What shows confidence in a professional setting?","During meetings with staff or clients, the way you conduct yourself will portray your level of confidence. Arriving on time, greeting everyone individually and introducing yourself clearly gives the impression that you are in control. Maintaining eye contact shows you are present and interested."));
        con_at_work_slides.add(new Slide("Why is there hope for people with self– doubt?","Confidence isn't something you're born with but something you develop. Every day, you are faced with challenges that can damage your sense of self– worth. However, you are also faced with opportunities to further develop your confidence and eliminate self– doubt. It is not easy, but it is worth it."));
        con_at_work_slides.add(new Slide("What can people who are confident at work do?","Confident people are comfortable in most situations. This is because they are assured that they are capable, fair– minded and willing to listen. If a confident person wishes to speak up in an awkward situation they do it with ease because they are comfortable with their abilities."));
        con_at_work_slides.add(new Slide("What is the main benefit of confidence?","When you are confident, you are willing to try new things without the fair of failure. A confident person accepts that they have weaknesses and is eager to learn from them. People like the company of confident person, they are interested in their opinions and enjoy spending time with them. Benefits A confident person knows that they don't need to win every time – whether it be a sports activity, a debate with colleagues or in a romantic way but they know they'll gain nothing if they don't try. More benefits of confidence: – You'll perform better in all aspects of your life; – You'll be happier; – You'll improve your social skills; – You'll be healthier."));
        con_at_work_slides.add(new Slide("What is confidence?","Confidence is having faith in your chosen course of action, no matter how tough the situation seems. It is trusting yourself and believing that your choices will work out well because you have made those decisions yourself."));

        Chapter con_at_work_chapter = new Chapter("Confidence at work", con_at_work_slides);

        List<Chapter> self_con_chapters = new LinkedList<>();
        self_con_chapters.add(confidience_chapter);
        self_con_chapters.add(all_about_u_chapter);
        self_con_chapters.add(new_con_chapter);
        self_con_chapters.add(con_at_work_chapter);

        Course confidience = new Course(2, 0, "Self-Confidience", self_con_chapters, 12456, R.drawable.course_img_self_confidience);

        courses.add(confidience);

        //---------------------------------------------------------------------



        courses.add(new Course(6, 1, "Job Interview", self_con_chapters,  12000, R.drawable.course_img_job_interview));
        courses.add(new Course(7, 1, "Successful Negotiating", self_con_chapters, 7000, R.drawable.course_img_negotiation));
        courses.add(new Course(8, 1, "Presentation Skills", nutrition_chapters, 2500, R.drawable.course_img_presentation));
        courses.add(new Course(9, 0, "Business Startup", nutrition_chapters,  2000, R.drawable.course_img_startup));
        courses.add(new Course(10, 0, "Career Planning Tips", nutrition_chapters,  25112, R.drawable.course_img_tipping));
        courses.add(new Course(11, 0, "Personal Finance", nutrition_chapters, 12542, R.drawable.course_accounting_3));
        courses.add(new Course(12, 3, "Fascinating Football", nutrition_chapters,  2151, R.drawable.course_test_picture_geography));

        int filled = 0;

        Collections.shuffle(courses);

        for (int i = 0; i < courses.size(); i++) {

            Course course = courses.get(i);


            if (course.getCatId() == catId) {

                Collections.rotate(courses, filled - i);
                filled++;
            }

        }


        return courses;
    }



    /*

    public static List<Course> getCourses(Context context, int catId) {

        List<Course> courses = new LinkedList<>();
        for (int i = 0; i < CourseContants.courses.size(); i++) {


            Course course = CourseContants.courses.get(i);


            if (course.getCatId() == catId) {

                courses.add(course);
            }

        }


        return courses;
    }

    //*/

    public static Course getCourse(Context context, int id) {
        List<Course> courses = Utilities.getCourses(context,0);

        for (Course course : courses)
            if (course.getId() == id)
                return course;
        return null;
    }


    public static List<Category> getCategories() {

        List<Category> categories = new LinkedList<>();


        categories.add(new Category(1, "Self-Development"));
        categories.add(new Category(2, "Business Strategy"));
        categories.add(new Category(3, "Career Skills"));
        categories.add(new Category(4, "Social Sciences"));
        categories.add(new Category(5, "Math and Logic"));
        categories.add(new Category(6, "Life Sciences"));

        return categories;
    }


    public static int getCatId(String title) {

        List<Category> categories = getCategories();

        for (Category category : categories) {
            if (category.getName().equals(title))
                return category.getId();
        }

        return 0;
    }
    /* End of testing methods */






    /*
        Below methods are used to show dialog messages upon user interaction. It could be some
        actions like reseting user password or show notification on wrong username or else.
     */

    // Method used to initialize dialog depending on usage because it uses the same view layout
    // we should disable some views to show proper dialog.
    public static AppCompatDialog getDialogForActions(Context context, int actions) {
        final AppCompatDialog dialog = new AppCompatDialog(context);
        dialog.setContentView(R.layout.dialog_custom);

        final TextView dialogTitle = (TextView) dialog.findViewById(R.id.dialog_title);
        final Button dialogLeftButton = (Button) dialog.findViewById(R.id.dialog_left_button);
        final Button dialogRightButton = (Button) dialog.findViewById(R.id.dialog_right_button);
        final TextView dialogMessage = (TextView) dialog.findViewById(R.id.dialog_message);
        final TextView dialogInstructions = (TextView) dialog.findViewById(R.id.dialog_instruction);
        final EditText dialogEdittext = (EditText) dialog.findViewById(R.id.dialog_edit_text);

        switch (actions) {
            case ACTION_SHOW_MESSAGE:
                dialogTitle.setVisibility(View.VISIBLE);
                dialogEdittext.setVisibility(View.GONE);
                dialogInstructions.setVisibility(View.GONE);
                dialogMessage.setVisibility(View.VISIBLE);
                dialogRightButton.setVisibility(View.VISIBLE);
                dialogLeftButton.setVisibility(View.VISIBLE);
                break;
            case ACTION_INPUT:
                dialogTitle.setVisibility(View.VISIBLE);
                dialogEdittext.setVisibility(View.VISIBLE);
                dialogInstructions.setVisibility(View.VISIBLE);
                dialogMessage.setVisibility(View.GONE);
                dialogRightButton.setVisibility(View.VISIBLE);
                dialogLeftButton.setVisibility(View.VISIBLE);
                break;
        }


        return dialog;
    }

    // Method to show dialog messages to notify user some actions. We can set title, message, button
    // values here.
    public static void showDialog(Context context, String title, String message, String button) {
        final AppCompatDialog dialog = Utilities.getDialogForActions(context, ACTION_SHOW_MESSAGE);

        final TextView dialogTitle = (TextView) dialog.findViewById(R.id.dialog_title);
        final Button dialogLeftButton = (Button) dialog.findViewById(R.id.dialog_left_button);
        final Button dialogRightButton = (Button) dialog.findViewById(R.id.dialog_right_button);
        dialogRightButton.setVisibility(View.GONE);
        final TextView dialogMessage = (TextView) dialog.findViewById(R.id.dialog_message);

        dialogTitle.setText(title);
        dialogMessage.setText(message);
        dialogLeftButton.setText(button);

        dialogLeftButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });


        dialog.show();
    }

    // Same as previous method only it is useful to use predefined string values in xml
    public static void showDialog(Context context, int title, int message, int button) {

        Resources resources = context.getResources();
        Utilities.showDialog(context, resources.getString(title), resources.getString(message),
                resources.getString(button));
    }
     /* End of dialog methods */


    public static void showToastMessage(Activity context, int resource) {

        Utilities.showToastMessage(context, context.getResources().getString(resource));
    }

    public static void showToastMessage(Activity context, String message) {

        LayoutInflater inflater = context.getLayoutInflater();
        View layout = inflater.inflate(R.layout.toast_custom,
                (ViewGroup) context.findViewById(R.id.toast_background));


        ((TextView) layout.findViewById(R.id.toast_message)).setText(message);

        // Create Custom Toast
        Toast toast = new Toast(context.getApplicationContext());
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(layout);
        toast.show();
    }


    public static void expand(final View v) {
        v.measure(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        final int targetHeight = v.getMeasuredHeight();

        // Older versions of android (pre API 21) cancel animations for views with a height of 0.
        v.getLayoutParams().height = 1;
        v.setVisibility(View.VISIBLE);
        Animation a = new Animation() {
            @Override
            protected void applyTransformation(float interpolatedTime, Transformation t) {
                v.getLayoutParams().height = interpolatedTime == 1
                        ? LinearLayout.LayoutParams.WRAP_CONTENT
                        : (int) (targetHeight * interpolatedTime);
                v.requestLayout();
            }

            @Override
            public boolean willChangeBounds() {
                return true;
            }
        };

        // 1dp/ms
        a.setDuration((int) (targetHeight / v.getContext().getResources().getDisplayMetrics().density));
        v.startAnimation(a);
    }

    public static void collapse(final View v) {
        final int initialHeight = v.getMeasuredHeight();

        Animation a = new Animation() {
            @Override
            protected void applyTransformation(float interpolatedTime, Transformation t) {
                if (interpolatedTime == 1) {
                    v.setVisibility(View.GONE);
                } else {
                    v.getLayoutParams().height = initialHeight - (int) (initialHeight * interpolatedTime);
                    v.requestLayout();
                }
            }

            @Override
            public boolean willChangeBounds() {
                return true;
            }
        };

        // 1dp/ms
        a.setDuration((int) (initialHeight / v.getContext().getResources().getDisplayMetrics().density));
        v.startAnimation(a);
    }

}

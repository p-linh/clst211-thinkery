package model;

import org.json.JSONObject;
import persistence.Writable;

// represents a discussion prompt
public class Prompt implements Writable {
    public String topic;
    public String question;
    public static final String apologyPrompts[] =
            {"Is it ever beneficial to follow the beliefs of the majority?",
            "Why are the ideas of the majority so powerful, but so easily influenced?",
            "What do you think Socrates' 'daimon' is in a modern context? Does everyone have something similar?",
            "Do you agree with Socrates that 'knowing that you know nothing' is also a kind of wisdom?"
            };
    public static final String symposiumPrompts[] =
            {"Which of the speeches do you agree with most, and why?",
            "What are your thoughts on Alcibiades' speech on Socrates? \nWhat do you think makes Socrates so appealing to him?",
            "What does 'looking at beauty in its true form' mean? How would we attempt to do this?",
            "How do we characterize abstract concepts as beautiful? With what criteria do we use for non-human beauty?"
            };
    public static final String phaedrusPrompts[] = {
            "Do you agree with Socrates that madness can be 'divinely inspired' and beneficial? What is this 'madness' in a modern context?",
            "Do you think that art that was not created by 'divinely inspired madness' is somehow inferior to one that was?",
            "How would one induced divinely inspired madness or come about it?",
            "What are the characteristics of 'good love' that Socrates describes and do you agree?",
            "What do you think 'growing wings of the soul' represent in human experiences?",
            "Why is the soul divided into three parts? \nDo you agree? If not, how many different parts are needed to adequately represent the soul?"
    };
    public static final String republic24Prompts[] = {
            "Will a perfectly just city ever be attainable? What would be needed for it to be attainable?",
            "Why do we develop into 'fevered cities' if it is harmful to us?",
            "Who/what would be the judge for what is just and what is not in the city? \nCan we trust their judgement?",
            "Is it best to only do what we are suited for? \nWhat if we are not particularly good at something, but want to do it? Would this lead to injustice?",
            "Consider someone who was educated and trained in the best way, and surrounded by the best people. " +
                    "\nIs it still possible for their soul to be corrupted?"
    };
    public static final String republic57Prompts[] = {
            "Do you agree that the best rulers are the ones who practice philosophy?",
            "Is it generally true that those who are naturally talented and are brought up in good families cannot practice philosophy? " +
                    "\nWhat makes it hard for them to do so?",
            "Do you think it's true that those who have suffered misery are better artists and philosophers?",
            "Why are the philosophers who are forced to 're-enter the cave' and to restrict their appetites more free than non-philosophers?",
            "What do you think about Plato's 'proto-feminist' views? How are they advocating for women's rights and how are they not?",
            "What might Plato's forms be, if it can even be defined? Could any human ever be able to truly understand and define one of the forms?",
            "What does the allegory of the cave represent in a modern context?",
            "Why are the 'the best among the philosophers are useless to the masses'?",
            "Why is it impossible for the majority to be philosophic?"
    };

    public Prompt(String topic, String question) {
        this.topic = topic;
        this.question = question;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    @Override
    public JSONObject toJson() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("topic", topic);
        jsonObject.put("question", question);
        return jsonObject;
    }
}

package vishal.springboot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import vishal.springboot.entity.WikimediaData;
import vishal.springboot.repository.WikimediaDataRepository;

@Service
public class KafkaDatabaseConsumer {

    private static final Logger logger = LoggerFactory.getLogger(KafkaDatabaseConsumer.class);
    private WikimediaDataRepository wikimediaDataRepository;

    public KafkaDatabaseConsumer(WikimediaDataRepository wikimediaDataRepository) {
        this.wikimediaDataRepository = wikimediaDataRepository;
    }

    @KafkaListener(topics = "wikimedia_recent_change",groupId = "myGroup")
    public void consume(String eventMessage){
        logger.info("Consumed Message - > {}",eventMessage);
        WikimediaData wikimediaData = new WikimediaData(eventMessage);
        wikimediaDataRepository.save(wikimediaData);
    }
}

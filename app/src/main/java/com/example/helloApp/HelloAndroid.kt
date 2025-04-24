<androidx.core.widget.NestedScrollView
    android:id="@+id/plant_detail_scrollview"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:clipToPadding="false"
    android:paddingBottom="@dimen/fab_bottom_padding"
    app:layout_behavior="@string/appbar_scrolling_view_behavior">

    <!-- Step 2) Comment out ConstraintLayout and its children –->
    <androidx.constraintlayout.widget.ConstraintLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:layout_margin="@dimen/margin_normal">

        <TextView
            android:id="@+id/plant_detail_name"
        ...
    
    </androidx.constraintlayout.widget.ConstraintLayout>
    <!-- End Step 2) Comment out until here –->

    <!-- Step 3) Add a ComposeView to host Compose code –->
    <androidx.compose.ui.platform.ComposeView
        android:id="@+id/compose_view"
        android:layout_width="match_parent"
        android:layout_height="match_parent"/>


@Composable
fun PlantDetailDescription() {
    Surface {
        Text("Hello Compose")
    }  
}
</androidx.core.widget.NestedScrollView>



class PlantDetailFragment : Fragment() {
    // ...
    override fun onCreateView(...): View? {
        val binding = DataBindingUtil.inflate<FragmentPlantDetailBinding>(
            inflater, R.layout.fragment_plant_detail, container, false
        ).apply {
            // ...
            composeView.setContent {
                // You're in Compose world!
                MaterialTheme {
                    PlantDetailDescription()
                }
            }
        }
        // ...
    }
}
